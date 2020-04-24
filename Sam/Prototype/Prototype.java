import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

public class Prototype
{
    private int frameSize = 800;
    private JFrame mainFrame;
    //added
    private int moves = 0;
    private JLabel score = new JLabel("Moves = " + moves);
    private GridCard gridCard;

    public Prototype(int size, Driver main)
    {
        this. frameSize = size;
        Prototype p = this;

        mainFrame = new JFrame("Memory Game");
        //mainFrame.setPreferredSize(new Dimension(frameSize, frameSize));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel backGround = new JPanel();

	JPanel stackMenu = new JPanel();
        stackMenu.setLayout(new BoxLayout(stackMenu, BoxLayout.Y_AXIS));
        gridCard = new GridCard(4,4,main,this);	

	//panel for scores
	JPanel scorePanel = new JPanel();
	JLabel time = new JLabel("Time : 60");
	JLabel highScore = new JLabel("High Score: 100");
        scorePanel.add(score);
        scorePanel.add(highScore); 
        scorePanel.add(time);
	stackMenu.add(scorePanel);

	//panel for difficulties
        JPanel diffPanel = new JPanel();
        String difficultyChoice[] = {"Choose Difficulty","Easy","Medium","Hard"};
        JComboBox difficulty = new JComboBox<>(difficultyChoice);
        String currentDifficulty = difficulty.getSelectedItem().toString();
        
        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        String playDifficulty = difficulty.getSelectedItem().toString();
                        //create new deck with difficulty, pass into gridcard
                        backGround.remove(gridCard);
                        gridCard = new GridCard(4 , 4, main, p);
                        backGround.add(gridCard,0);

                        moves=0;
                        score.setText("Moves = " + moves);

                        mainFrame.revalidate();
                }
        });

	JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        //create new deck with currentDifficulty, pass into gridcard
                        backGround.remove(gridCard);
                        gridCard = new GridCard(4 , 4, main, p);
                        backGround.add(gridCard,0);

                        moves=0;
                        score.setText("Moves = " + moves);

                        mainFrame.revalidate();
                }
        });

	diffPanel.add(difficulty);
	diffPanel.add(play);
	diffPanel.add(reset);
	stackMenu.add(diffPanel);

	
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

    public void updateScore()
    {
        moves++;
        score.setText("Moves = " + moves);
        mainFrame.revalidate();
    }
}
