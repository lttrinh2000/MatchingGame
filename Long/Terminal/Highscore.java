import java.io.*;
import java.util.*;

public class Highscore {
	public void saveHighscore(String name, String score) {
		try {
			File highscore = new File("save_highscore.csv"); 

			FileWriter writer = new FileWriter(highscore);
	
			writer.write(name + "," + score);
			
			writer.close();
		}

		catch (IOException e) {
			System.out.println("Error occured");
		}
	}

	public int getHighscore(String filename) {
		File file = new File(filename);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			String[] strArray = line.split(",");
			return Integer.parseInt(strArray[1]);
		}

		catch (Exception e) {
			System.out.println(filename + " not open");
			return 0;
		}
	}		

	/* public static void main(String[] args) {
		Highscore score = new Highscore();
		score.saveHighscore("Test Name","100000");
		System.out.println(score.getHighscore("save_highscore.csv"));
	} */
}
