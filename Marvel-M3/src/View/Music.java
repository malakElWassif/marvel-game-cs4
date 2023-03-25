package View;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Music {

	public void PlayMusic(String path) {
		try {
		File SongPath = new File(path);
		if(SongPath.exists()) {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(SongPath);
			Clip clip;
			
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			
			
		
	}
		}
		catch(Exception e) {
			
		}
}
	
	public void StopMusic(String path) {
		try {
		File SongPath = new File(path);
		if(SongPath.exists()) {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(SongPath);
			Clip clip;
			
			clip = AudioSystem.getClip();
			clip.open(audioInput);
			long getTime = clip.getMicrosecondPosition();
			clip.stop();
			
			
		
	}
		}
		catch(Exception e) {
			
		}
}

}
