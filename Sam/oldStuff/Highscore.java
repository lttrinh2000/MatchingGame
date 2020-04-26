import java.io.*;
import java.util.*;

public class Highscore {
	/**
	 * DON'T USE THIS VERSION modified for Unit Test
	**/

	boolean execute = false;
	int h_score = 100;

	public boolean isExecute() {
		return execute;
	}

	public void saveHighscore(String name, int score, String filename) {
		try {
			File highscore = new File(filename);
                	FileWriter writer = new FileWriter(highscore);
		
			//writer.write(name + "," + score);

			if(score <= h_score)
			{
				execute = true;	
				writer.write(System.getProperty( "line.separator" ));
				writer.write(name + "," + score);
			}

			else
				execute = false;

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
	
	public static void main(String[] args) {
		Highscore score = new Highscore();
		score.saveHighscore("Initial Test",10,"save.csv");
		System.out.println(score.isExecute());
	}

}
