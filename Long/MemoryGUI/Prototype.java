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
    private String currentDifficulty;
    private int timeLeft=60;
    private Timer timer;

    private int currentScore;
    private int pos; 

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
        Deck d = new Deck("Easy");
        gridCard = new GridCard(d,main,this);	

	
	//panel for scores
	/* JPanel scorePanel = new JPanel();
        JLabel time = new JLabel("Time : " + timeLeft);

        ActionListener timerAction = new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    timeLeft-=1;
                    time.setText("Time : " + timeLeft);
        }};
        timer = new Timer(1000,timerAction);
        timer.start();        

	JLabel highScore = new JLabel("High Score: " + currentScore);
        scorePanel.add(score);
        scorePanel.add(highScore); 
        scorePanel.add(time);
	stackMenu.add(scorePanel); */

	//panel for difficulties
        JPanel diffPanel = new JPanel();

	/**
	 * Remove "Choose Difficulty" for the HighSCore class to work
	**/
        String difficultyChoice[] = {"Easy","Medium","Hard"};
        JComboBox difficulty = new JComboBox<>(difficultyChoice);
        currentDifficulty = difficulty.getSelectedItem().toString();
        
        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        String playDifficulty = difficulty.getSelectedItem().toString();
                        Deck newDeck = new Deck(playDifficulty);
			
			/**
			 * Added shuffle for the deck below
			**/
			newDeck.shuffle();
                        backGround.remove(gridCard);
                        gridCard = new GridCard(newDeck, main, p);
                        backGround.add(gridCard,0);

                        moves=0;
                        score.setText("Moves = " + moves);
                        timer.stop();
                        timeLeft=60;
                        timer.start();

                        mainFrame.revalidate();
                        mainFrame.pack();

                        currentDifficulty = playDifficulty;
                }
        });


	//panel for scores
        JPanel scorePanel = new JPanel();
        JLabel time = new JLabel("Time : " + timeLeft);

        ActionListener timerAction = new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    timeLeft-=1;
                    time.setText("Time : " + timeLeft);
        }};
        timer = new Timer(1000,timerAction);
        timer.start();

        /**
         * NEW HighSCore added below
        **/
        HighScore scoreNumber = new HighScore();
        pos = scoreNumber.position(currentDifficulty);
        currentScore = scoreNumber.getCurrentScore(pos);


        JLabel highScore = new JLabel("High Score: " + currentScore);
        scorePanel.add(score);
        scorePanel.add(highScore);
        scorePanel.add(time);
        stackMenu.add(scorePanel);
	

	JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener()
        {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                        Deck newDeck = new Deck(currentDifficulty);
                        backGround.remove(gridCard);
                        gridCard = new GridCard(newDeck, main, p);
                        backGround.add(gridCard,0);

                        moves=0;
                        timer.stop();
                        timeLeft=60;
                        timer.start();
                        score.setText("Moves = " + moves);

                        mainFrame.revalidate();
                        mainFrame.pack();
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
    public int stopTime()
    {
        timer.stop();
        return timeLeft;
    }
}
