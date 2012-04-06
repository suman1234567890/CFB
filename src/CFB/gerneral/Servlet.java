package CFB.gerneral;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.JavaStreamingAudioPlayer;
import com.sun.speech.freetts.audio.NullAudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import com.sun.speech.freetts.FreeTTS;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import com.sun.speech.freetts.OutputQueue;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


/**
 * Servlet implementation class for Servlet: Servlet
 *
 */
 public class Servlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   PrintWriter writer;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String VOICENAME= "kevin16";
		
		String Values = request.getParameter("Text");
        System.out.print("hiiiiiiiiiiiiiiiiiii "+Values);
	    

		//response.setHeader("Content-Disposition", "filename=abc.wav") ;
		// TODO Auto-generated method stub
		try
		{
			
						
			Voice voice;
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        voice = voiceManager.getVoice(VOICENAME);
	        voice.allocate();
	        javax.sound.sampled.AudioFileFormat.Type type = getAudioType("Sumon1.wav");
	        AudioPlayer audioPlayer = null;
	        if(audioPlayer == null)
	        audioPlayer = new NullAudioPlayer();
	        audioPlayer = new SingleFileAudioPlayer(getBasename("Sumon1.wav"), type);
	        
	        System.out.println("audioPlayer "+audioPlayer);
	        voice.setAudioPlayer(audioPlayer);
	       
	        voice.speak(Values);
	        
	        
	                
	        File fileMp3 = new File("Sumon1.wav");
	        
	        FileInputStream fis = new FileInputStream(fileMp3);
	        response.setContentType("audio/x-wav");
	        response.setHeader("Content-Disposition", "filename=abc.wav");
	        response.setContentLength((int) fileMp3.length());
	        OutputStream os = response.getOutputStream();

	        try {
	            int byteRead = 0;
	            while ((byteRead = fis.read()) != -1) {
	                os.write(byteRead);
	            }
	           os.flush();
	        } catch (Exception excp) {
	            //downloadComplete = "-1";
	            excp.printStackTrace();
	        } finally {
	            os.close();
	            fis.close();
	            audioPlayer.close();
	            
	        }
	       
	       
	        
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	} 
	public static String getBasename(String path)
	{
	int index = path.lastIndexOf(".");
	if(index == -1)
	return path;
	else
	return path.substring(0, index);
	}
	public static javax.sound.sampled.AudioFileFormat.Type getAudioType(String file)
	{
	javax.sound.sampled.AudioFileFormat.Type types[] = AudioSystem.getAudioFileTypes();
	String extension = getExtension(file);
	for(int i = 0; i < types.length; i++)
	if(types[i].getExtension().equals(extension))
	return types[i];
	return null;
	}
	public static String getExtension(String path)
	{
	int index = path.lastIndexOf(".");
	if(index == -1)
	return null;
	else
	return path.substring(index + 1);
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}