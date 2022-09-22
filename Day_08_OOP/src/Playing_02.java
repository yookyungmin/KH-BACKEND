import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Playing_02 {

	public static void main(String[] args) {
	
		try{
		    FileInputStream fis = new FileInputStream("musicc.mp3");
		    Player playMP3 = new Player(fis);
		    playMP3.play();
		}
		catch(Exception exc){
		    exc.printStackTrace();
		    System.out.println("Failed to play the file.");
		}

	}

}
