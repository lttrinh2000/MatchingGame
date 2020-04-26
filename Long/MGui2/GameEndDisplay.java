import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameEndDisplay
{
    public static int frameSize = 300;
    private JFrame exitFrame;

    int userTime;
    int userMoves;
    String difficulty;

    HighScore HighScore = new HighScore();
    String userName;
    int prevHigh;
    String prevName;

    boolean playAgainChoice;

    public GameEndDisplay(int timeTaken, int numberMoves, String difficulty)
    {
        this.userTime = timeTaken;
        this.userMoves = numberMoves;
	this.difficulty = difficulty;
        prevName = HighScore.getPrevName(HighScore.position(difficulty));
        prevHigh = HighScore.getCurrentScore(HighScore.position(difficulty));
    }

    public void createDisplay()
    {
        // top level container for end-of-game page
        exitFrame = new JFrame("Memory");
        exitFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //outer container
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
    
        // panel for game info
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.PAGE_AXIS));
        // display user moves and time
        JLabel moves = new JLabel("Moves: " + userMoves);
        statsPanel.add(moves);
        JLabel time = new JLabel("Time taken: " + userTime + " seconds");
        statsPanel.add(time);
        container.add(statsPanel);
        
        // panel for prev high score and new high score info
        JPanel scoringPanel = new JPanel();
        scoringPanel.setLayout(new BoxLayout(scoringPanel, BoxLayout.PAGE_AXIS));
        //previous scoring info
        JLabel displayHighscore = new JLabel("Previous High Score: " + prevHigh + " by user " + prevName);
        scoringPanel.add(displayHighscore);
        // if user got a high score, ask for name
        if (userMoves < prevHigh)
        {
            JLabel newHigh = new JLabel("You got a new high score!");
            scoringPanel.add(newHigh);
            JTextField nameTextBox = new JTextField();
            scoringPanel.add(nameTextBox);

            JButton submitButton = new JButton("OK");
            scoringPanel.add(submitButton);

            submitButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    userName = nameTextBox.getText();
                    nameTextBox.setEnabled(false);
                    submitButton.setEnabled(false);

                    HighScore.saveHighScore(userName, String.valueOf(userMoves), HighScore.position(difficulty));
                }
            });
        }
        else if (userMoves == prevHigh)
        {
            JLabel newHigh = new JLabel("You almost got a new high score!");
            scoringPanel.add(newHigh);
        }
        else
        {
            JLabel newHigh = new JLabel("No high score.");
            scoringPanel.add(newHigh);
        }
        container.add(scoringPanel);

        JPanel playAgainPanel = new JPanel(new FlowLayout());
        JLabel playAgainQuestion = new JLabel("Would you like to play again?");
        JButton yesButton = new JButton("Play Again!");
        JButton noButton = new JButton("No.");
        playAgainPanel.add(playAgainQuestion);
        playAgainPanel.add(yesButton);
        playAgainPanel.add(noButton);
        yesButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                playAgainChoice = true;
            }
        });
        noButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                playAgainChoice = false;
            }
        });
        container.add(playAgainPanel);

        // pack and toggle visibility on
        exitFrame.add(container);
        exitFrame.pack();
        exitFrame.setVisible(true);
    }
    

    public boolean playAgain()
    {
        return playAgainChoice;
    }

    /*
    public static void main(String[] args)
    {
        int time = 45;
        int moves = 1;
        int prevHigh = 100;
        String prevName = "Betty";

        GameEndDisplay end = new GameEndDisplay(time,moves,prevHigh,prevName);
        end.createDisplay();
    }
    */
}
