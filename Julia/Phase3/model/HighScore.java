package model;

import java.io.*;
import java.util.*;

public class Highscore {
	public void saveHighscore(String name, String score, String filename) {
		try {
			File highscore = new File(filename); 
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
	
	public String getHighscoreName(String filename) {
		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			String[] strArray = line.split(",");
			return strArray[0];
		}

		catch (Exception e) {
			System.out.println(filename + " not open");
			return "No Name Available";
		}
	}
}
