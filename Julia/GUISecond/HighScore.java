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

    public int position(String d) 
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

    public void saveHighScore(String name, String score, int pos) 
    {
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

    public int getCurrentScore(int pos)
    {
        try
        {
			String line = getHighScore(pos);
			String[] strArray = line.split(",");
			return Integer.parseInt(strArray[1]);			
        }

        catch (Exception e) 
        {
            System.out.println("current score not working");
            return 999;
        }
	}

    public String getHighScore(int pos)
    {
        try
        {
			List<String> content = Files.readAllLines(Paths.get("save_highscore.csv"));
			return content.get(pos);
		}

        catch (Exception e)
        {
			System.out.println("save_highscore.csv not open");
			return "";
		}
    }
    
    public String getPrevName(int pos)
    {
        try
        {
			String line = getHighScore(pos);
			String[] strArray = line.split(",");
			return strArray[0];			
        }

        catch (Exception e) 
        {
            System.out.println("current score not working");
            return "Not Found";
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