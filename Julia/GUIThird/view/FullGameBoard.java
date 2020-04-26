package view;

import model.*;
import javax.swing.*;
import java.awt.event.*;

public class FullGameBoard 
{
    
    protected JFrame mainFrame;
    private int frameSize;
    private JButton play;
    private JButton reset;
    private JComboBox difficulty;
    private LayoutCards cards;
    private JPanel background;
    private Timer timer;
    private int timeLeft = 60;
    private ActionListener timerAction;
    private JLabel highScore;
    private JLabel score;
    //private Deck deck;
    
    public FullGameBoard(LayoutCards cards)
    {
        this.cards = cards;
    }

    public void createBoard(int size)
    {
        this.frameSize = size;
        mainFrame = new JFrame("Memory Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel stackMenu = new JPanel();
        stackMenu.setLayout(new BoxLayout(stackMenu, BoxLayout.Y_AXIS));


        // Interact panel- difficulty, play, reset
        JPanel diffPanel = new JPanel();

        play = new JButton("Play");
        diffPanel.add(play);

        reset = new JButton("Reset");
        diffPanel.add(reset);

        String difficultyChoice[] = {"Easy","Medium","Hard"};
        difficulty = new JComboBox<>(difficultyChoice);   
        diffPanel.add(difficulty);
        
        stackMenu.add(diffPanel);
        

        // Info planel- moves, high score, time
        JPanel scorePanel = new JPanel();

        score = new JLabel("Score: 0");
        scorePanel.add(score);

        highScore = new JLabel();
        scorePanel.add(highScore);
        updateHighScore();

        JLabel time = new JLabel("Time : " + timeLeft);
        timerAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {
                timeLeft-=1;
                time.setText("Time : " + timeLeft);
            }
        };
        timer = new Timer(1000,timerAction);
        timer.start();
        scorePanel.add(time);

        stackMenu.add(scorePanel);


        // cards = new LayoutCards(new Deck("Easy"));
        background = new JPanel();
        background.add(stackMenu);
        background.add(cards);

        // adding cards, buttons, and info to the mainFrame
        mainFrame.add(background);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    //Action Listeners
    public void startGame(ActionListener l)
    {
        play.addActionListener(l);
    }
    public void resetGame(ActionListener l)
    {
        reset.addActionListener(l);
    }

    // Interacting with this class from controller
    public String getDifficulty()
    {
        return difficulty.getSelectedItem().toString();
    }
    public void placeCards(Deck d)
    {
        background.remove(cards);
        cards = new LayoutCards(new Deck(getDifficulty()));
        background.add(cards);
        mainFrame.revalidate();
        mainFrame.pack();
        mainFrame.revalidate();
        mainFrame.pack();
    }
    public void resetTime()
    {
        timer.stop();
        timeLeft = 60;
        timer.start();
    }
    public int getTime()
    {
        return timeLeft;
    }
    public void updateScore(int moves)
    {
        score.setText("Score: " + moves);
    }
    public void updateHighScore()
    {
	    HighScore scoreNumber = new HighScore();
        int HighestScore = scoreNumber.getHighScoreValue(getDifficulty());
        highScore.setText("High Score: " + HighestScore);
    }
    public void updateMainFrame()
    {
        mainFrame.revalidate();
        mainFrame.pack();
    }
    public boolean playAgain()
    {
        int choice = JOptionPane.showConfirmDialog(mainFrame, "Play again?", "Results", JOptionPane.YES_NO_OPTION);
        return choice == JOptionPane.YES_OPTION;
    }
}