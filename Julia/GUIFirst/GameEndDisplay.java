import java.awt.*;
import javax.swing.*;

public class GameEndDisplay
{
    public static int frameSize = 300;
    private JFrame exitFrame;

    int userTime;
    int userMoves;
    int prevHigh;
    String prevName;

    boolean setHigh = false;
    String userName;

    public GameEndDisplay(int time, int moves, int prevHigh, String prevName)
    {
        this.userTime = time;
        this.userMoves = moves;
        this.prevHigh = prevHigh;
        this.prevName = prevName;
    }

    public void createDisplay()
    {
        // top level container for end-of-game page
        exitFrame = new JFrame("Memory");
        exitFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // display user moves and time
        JLabel moves = new JLabel("Moves: " + userMoves);
        JLabel time = new JLabel("Time taken: " + userTime);
        exitFrame.add(moves);
        exitFrame.add(time);

        // display previous high score
        JLabel displayHighscore = new JLabel("Previous High Score: " + prevHigh);
        exitFrame.add(displayHighscore);

        // if user got a high score, ask for name
        if (userMoves < prevHigh)
        {
            JLabel newHigh = new JLabel("You got a new high score!");
            exitFrame.add(newHigh);
            JTextField userName = new JTextField();
            userName.setPreferredSize(new Dimension(30,30));
            exitFrame.add(userName);
            setHigh = true;
        }
        else if (userMoves == prevHigh)
        {
            JLabel newHigh = new JLabel("You almost got a new high score!");
            exitFrame.add(newHigh);
        }
        else
        {
            JLabel newHigh = new JLabel("No high score.");
            exitFrame.add(newHigh);
        }

        exitFrame.pack();
        exitFrame.setVisible(true);
    }

    public boolean newHighscore()
    {
        return setHigh;
    }

    public String getNewHighscoreName()
    {
        return userName;
    }

    public boolean playAgain()
    {
        int choice = JOptionPane.showConfirmDialog(exitFrame, "Do you want to play again?", "END GAME", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
}