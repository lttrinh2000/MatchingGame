package model;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class HighScore 
{
	protected File highscore;		

    public HighScore()
    {
        try 
        {
			File highscore = new File("save_highscore.csv");
			highscore.createNewFile();
		}
        catch (Exception e) 
        {
			System.out.println("Can't create file");
		}
	}

    private int position(String d) 
    {
		if (d == "Easy")
        {
        	return 0;
	    }
        else if (d == "Medium")
        {
        	return 1;
        }
        else if (d == "Hard")
	    {
            return 2;
		}
        else
        {
			System.out.println("Position not working");
			return 99;
		}
	}

    public void saveHighScore(String name, String score, String difficulty) 
    {
        int pos = position(difficulty);
        try 
        {
			FileWriter writer = new FileWriter("save_highscore.csv",true);

			List<String> lines = Files.readAllLines(Paths.get("save_highscore.csv"));
			lines.set(pos, name + "," + score);
			Files.write(Paths.get("save_highscore.csv"), lines);
			
			writer.close();
		}
        catch (IOException e) 
        {
			System.out.println("Error occured");
		}
	}

    public int getHighScoreValue(String difficulty)
    {
        int pos = position(difficulty);
        try
        {
            List<String> content = Files.readAllLines(Paths.get("save_highscore.csv"));
			String[] strArray = content.get(pos).split(",");
			return Integer.parseInt(strArray[1]);			
        }

        catch (Exception e) 
        {
            System.out.println("current score not working");
            return 999;
        }
	}

    public String getHighScoreName(String difficulty)
    {
        int pos = position(difficulty);
        try
        {
			List<String> content = Files.readAllLines(Paths.get("save_highscore.csv"));
			String[] strArray = content.get(pos).split(",");
			return strArray[0];
		}

        catch (Exception e)
        {
			System.out.println("save_highscore.csv not open");
			return "";
		}
    }
    
    public void resetScore()
    {
        try 
        {
            FileWriter writer = new FileWriter("save_highscore.csv",false);
            for(int i=0; i<3; i++)
            {
				writer.write("Reset score,999999");
				writer.write(System.getProperty( "line.separator" ));
			}
			writer.close();
		}
        catch (IOException e)
        {
            System.out.println("Error occured");
        }
	}
}