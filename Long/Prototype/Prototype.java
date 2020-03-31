import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

public class Prototype
{
    private int frameSize = 800;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this. frameSize = size;

        mainFrame = new JFrame("Memory Game");
        //mainFrame.setPreferredSize(new Dimension(frameSize, frameSize));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel backGround = new JPanel();

	JPanel stackMenu = new JPanel();
	stackMenu.setLayout(new BoxLayout(stackMenu, BoxLayout.Y_AXIS));	

	//panel for scores
	JPanel scorePanel = new JPanel();
	JLabel score = new JLabel("Score: 0");
	JLabel time = new JLabel("Time : 60");
	JLabel highScore = new JLabel("High Score: 100");
        scorePanel.add(score);
        scorePanel.add(highScore); 
        scorePanel.add(time);
	stackMenu.add(scorePanel);

	//panel for difficulties
        JPanel diffPanel = new JPanel();
        JButton play = new JButton("Play");	
	JButton reset = new JButton("Reset");
        String difficultyChoice[] = {"Choose Difficulty","Easy","Medium","Hard"};
	JComboBox difficulty = new JComboBox<>(difficultyChoice);
	diffPanel.add(difficulty);
	diffPanel.add(play);
	diffPanel.add(reset);
	stackMenu.add(diffPanel);

	/*JPanel table = new JPanel();
	table.setLayout(new BoxLayout(table, BoxLayout.Y_AXIS));
        CardPanel cardRows = new CardPanel(frameSize);
        cardRows.add(new Card(Card.Type.centerCircle, 1), true);
        cardRows.add(new Card(Card.Type.centerCircle, 1), true);
        table.add(cardRows); */

	GridCard gridCard = new GridCard(4,4);
	
	backGround.add(gridCard);
	backGround.add(stackMenu);
	mainFrame.add(backGround);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JFrame getFrame()
    {
        return mainFrame;
    }
}
