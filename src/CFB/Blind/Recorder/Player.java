package CFB.Blind.Recorder;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.*;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.AudioFormat.Encoding;

import CFB.Blind.Recorder.AudioApplet.uploadThread;

public class Player extends Applet implements KeyListener{
	private static final long serialVersionUID = 1L;
	//Global declarations
	 protected boolean running;
	 int uploadstatestaus=0;
	 ByteArrayOutputStream out = null;
	 AudioFileFormat.Type fileType;
	 Object lock = new Object();
	 TargetDataLine line = null;
	 SourceDataLine sline = null;
	 volatile boolean paused = false;
	 boolean first;
	 TextArea displayArea;
	 int dis=0;
	  private AudioClip clip;
	   private AppletContext context;
	   URL url=null;
	   String result="";
	public void init () {
		context = this.getAppletContext();
	     // Construct the button
	     Button beep = new Button("Beep");

	     // add the button to the layout
	     this.add(beep);
	     displayArea = new TextArea(5, 20);
	 	 displayArea.setEditable(false);
	 	 this.add(displayArea);


	     // specify that action events sent by this
	     // button should be handled by a new BeepAction object
	     beep.addKeyListener(this);
	     context = this.getAppletContext();
	     try{
	    	 
	    	 //uri=this.getDocumentBase();
	    	 
	     }
	     catch (Exception e)
	     {
	    	 
	     }
	   
	   }
	public void keyReleased(KeyEvent e) {
		//displayInfo(e, "KEY RELEASED: ");
		dis=0;
		displayArea.append("\nKey release");
		System.out.print("STOP AUDIO");
		stopAudio();
		   uploadAudio();
		   System.out.print("End Upload");
		   System.out.print("result is "+result);

	    }

	    /** Handle the button click. */
	    public void actionPerformed(ActionEvent e) {
		//Clear the text components.
		displayArea.setText("");
		

		
		
	    }
	public void keyPressed(KeyEvent e) {
			if(dis==0)
			{
				dis=1;
				displayArea.append("\nKey Pressed");
				recordAudio();
			}
			
		
	    }
	
	private void recordAudio() 
	{
		  first=true;
		  try {
		   final AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;                      
		   final AudioFormat format = getFormat();
		   DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		   line = (TargetDataLine)AudioSystem.getLine(info);               
		   line.open(format);
		   line.start();

		   Runnable runner = new Runnable() {
		    int bufferSize = (int) format.getSampleRate()* format.getFrameSize();
		    byte buffer[] = new byte[bufferSize];           

		    public void run() {
		     out = new ByteArrayOutputStream();
		     running = true;
		     try {                      
		     while (running) {                           
		      int count = line.read(buffer, 0, buffer.length);
		      if (count > 0) {
		       out.write(buffer, 0, count);
		       InputStream input = new ByteArrayInputStream(buffer);
		       final AudioInputStream ais = new AudioInputStream(input, format, buffer.length /format.getFrameSize());
		      }                           
		     }
		     out.close();
		     }catch (IOException e) {                    
		      System.exit(-1);
		     }
		    }
		   };
		   Thread recordThread = new Thread(runner);
		   recordThread.start();
		  }catch(LineUnavailableException e) {
		   System.err.println("Line Unavailable:"+ e);
		   e.printStackTrace();
		   System.exit(-2);
		  }
		  catch (Exception e) {
		   System.out.println("Direct Upload Error");
		   e.printStackTrace();
		  }
	 }
	 private AudioFormat getFormat() 
	 {
		  Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		  float sampleRate=  16000.0F;
		  int sampleSizeInBits = 16;
		  int channels = 1;
		  int frameSize = 2;
		  float frameRate = 16000.0F;
		  boolean bigEndian = false;
		  return new AudioFormat(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
	}//End of getAudioFormat method
	 
	 class uploadThread extends Thread{
		  public void run(){
			  
			 
		   AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

		   byte audio[] = out.toByteArray();
		   InputStream input = new ByteArrayInputStream(audio);
		   final AudioFormat format = getFormat();
		   final AudioInputStream in = new AudioInputStream(input, format, audio.length /format.getFrameSize());
		  
		   try {
				
				URL servlet=new URL("http://localhost:8080/TGMC-version1/AudioUpload");
				HttpURLConnection con = (HttpURLConnection) servlet
						.openConnection();
				//con.setRequestProperty("Content-type","sumon");
				con.setRequestProperty("Content-Type",getContentType(format));
				
				con.setDoInput(true);
				con.setDoOutput(true);
				con.setRequestMethod("POST");
				con.setChunkedStreamingMode(2048);
				con.connect();

				OutputStream out = con.getOutputStream();

				byte[] buffer = new byte[10240];
				int totalRead = 0;
				while (true) {
					int numRead = in.read(buffer);
					if (numRead < 0) {
						break;
					}
					out.write(buffer, 0, numRead);
					out.flush();
					totalRead += numRead;
				}

				out.close();
				in.close();
				
				System.out.println("Posted total of  " + totalRead
						+ " audio bytes");
				System.out.println("Http response line: "
						+ con.getResponseMessage());
				InputStream instr = con.getInputStream();
				ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
				try {
					result = (String) inputFromServlet.readObject();
					System.out.print("Result is+"+result);
					displayArea.append("\nResult:'"+result+"'");
					
					/*
					AudioClip clip;
					AppletContext context;
					context = this.getAppletContext();*/
					
			         
					System.out.print("Upload Rnd");
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.print(e);
					e.printStackTrace();
				}
				inputFromServlet.close();
				instr.close();

			} catch (IOException e) {
				e.printStackTrace();
				
			}
			uploadstatestaus=0;
		  }
	 }
	 class speak extends Thread
	 {
		 public void run()
		 {
			 System.out.print("Speak");
			 clip.loop();
			 
		 }
	 }
	 
	 private String getContentType(AudioFormat format) {
			String encoding = null;
			if (format.getEncoding() == AudioFormat.Encoding.ULAW) {
				encoding = "MULAW";
			} else if (format.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
				encoding = "L16";
			}
			System.out.print("AUDIO=" + encoding + "; CHANNELS=" + format.getChannels()
					+ "; RATE=" + (int) format.getSampleRate() + "; BIG="
					+ format.isBigEndian());
			return "AUDIO=" + encoding + "; CHANNELS=" + format.getChannels()
					+ "; RATE=" + (int) format.getSampleRate() + "; BIG="
					+ format.isBigEndian();
		}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 private void stopAudio() {
		  if (sline != null) {
		   sline.stop();
		   sline.close();
		  }else {
		   line.stop();
		   line.close();
		  }
		 }
	 private void uploadAudio() {
		 	uploadstatestaus=1;
		  
		  //th.stop();
		  
		  //clip.loop();
		  //th=new speak();
		  Thread th= new uploadThread();
		  th.start();
		  while(th.isAlive());
		  String audioURL = "http://localhost:8080/TGMC-version1/abc.wav?Text=You%20said%20"+result;
		  System.out.print(audioURL);
		  try {
			url = new URL(this.getDocumentBase(), audioURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  clip = context.getAudioClip(url);
		  clip.loop();
		 }
	 

	


}
