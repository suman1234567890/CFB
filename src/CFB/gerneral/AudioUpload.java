package CFB.gerneral;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat.Encoding;

import edu.cmu.sphinx.frontend.util.AudioFileDataSource;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/**
 * Servlet implementation class for Servlet: AudioUpload
 *
 */
 public class AudioUpload extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   File file;
   String path;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AudioUpload() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	 private AudioFormat getFormat() {
		  Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		  float sampleRate=  16000.0F;
		  int sampleSizeInBits = 16;
		  int channels = 1;
		  int frameSize = 2;
		  float frameRate = 16000.0F;
		  boolean bigEndian = false;
		  return new AudioFormat(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
		 }
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
		file = new File("C:\\12345.wav");
		
		path=file.getPath();
		response.setContentType("application/x-java-serialized-object");
        InputStream is = request.getInputStream();
        final AudioFormat format = getFormat();
        OutputStream outstr=null;
        ObjectOutputStream oos=null;
        
        
        int byteCnt ;
        
        try
        {
           // create a buffer. 4K!
           byte[] buffer = new byte[10240];
           ByteArrayOutputStream out = new ByteArrayOutputStream();
           // read from input stream and write to file stream.
           byteCnt = 0;
           outstr = response.getOutputStream();
			oos = new ObjectOutputStream(outstr);
           
           while (true)
           {
              int bytes = is.read(buffer);
              
              if (bytes < 0) break;
              {
            	  byteCnt += bytes;
            	  out.write(buffer, 0, bytes);
            	  
              }

              System.out.println("Byte:"+byteCnt);
              //fos.write(buffer, 0, bytes);
           }
           byte audio[] = out.toByteArray();
           InputStream input = new ByteArrayInputStream(audio);
           
           AudioInputStream ais = new  AudioInputStream(input, format, byteCnt /format.getFrameSize());
           
           AudioSystem.write(ais,fileType,file);
           // flush the stream.
           //fos.flush();
        } // end of try block.
        
        finally
        {
        	
           is.close();
           //fos.close();
           System.out.print("I am here1");
           String result=startRecord("12345.wav");
           //response.sendRedirect("abc.html");
           System.out.print("End");
           
			oos.writeObject(result+".");
			oos.flush();
			oos.close();

           

           // set last mod date for this file.
           
        }
        
		// TODO Auto-generated method stub
        
        
	} 
	private String startRecord(String fileName)
	{
		
		URL audioURL;
		
		ConfigurationManager cm;
        cm = new ConfigurationManager(AudioUpload.class.getResource("helloworld.config.xml"));
        
        audioURL = AudioUpload.class.getResource("C:\\12345.wav");
        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
        recognizer.allocate();
 
        AudioFileDataSource dataSource = (AudioFileDataSource) cm.lookup("audioFileDataSource");
        dataSource.setAudioFile(file, null);

        // Loop until last utterance in the audio file has been decoded, in which case the recognizer will return null.
        Result result;
        String res="";
        System.out.println("you said1:");
        while ((result = recognizer.recognize())!= null) {

                String resultText = result.getBestResultNoFiller();
                System.out.println(" "+resultText);
                res=res+resultText;
        }
        return res;
        
		

	}
	
}