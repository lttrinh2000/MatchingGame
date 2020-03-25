import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

public class Prototype
{
    private int frameSize = 400;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this.frameSize = size;

        mainFrame = new JFrame("Black Jack");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cardTable = new JPanel();
        cardTable.setLayout(new BoxLayout(cardTable, BoxLayout.Y_AXIS));
        JPanel dealerHand = new HandPanel("MEMORY GAME", frameSize);
        JPanel userHand = new HandPanel("YOU", frameSize);
        cardTable.add(dealerHand);
        cardTable.add(userHand);

        // panel for scores
        JPanel scorePanel = new JPanel();
        JLabel score = new JLabel("Score: 0");
        JLabel time = new JLabel("Time : 60");
        JLabel highScore = new JLabel("High Score: 100");
        scorePanel.add(score);
        scorePanel.add(highScore);
        scorePanel.add(time);
        cardTable.add(scorePanel);

        //panel for difficulties
        JPanel diffPanel = new JPanel();
        JButton play = new JButton("Play");
        JButton reset = new JButton("Reset");
        String difficultyChoice[] = {"Choose Difficulty","Easy","Medium","Hard"};
        JComboBox difficulty = new JComboBox<>(difficultyChoice);
        diffPanel.add(difficulty);
        diffPanel.add(play);
        diffPanel.add(reset);
        cardTable.add(diffPanel);


        // place card table into the top level frame
        mainFrame.add(cardTable);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    /**
     * Do not remove this meethod
     */
    public JFrame getFrame()
    {
        return mainFrame;
    }
}
