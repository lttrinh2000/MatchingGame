import javax.swing.*; 

public class Driver
{
    boolean selected=false;
    boolean play = true;
    Card c;
    JButton button1 = new JButton("Placeholder");
    JButton button2 = new JButton("Placeholder");

    public static void main(String []args)
    {
        GameBoard memoryGameMain = new GameBoard(400,new Driver());
    }
    public void switchSelected()
    {
        selected = !selected;
    }
    public boolean cardSelected()
    {
        return selected;
    }
    public Card getCard()
    {
        return c;
    }
    public void setCard(Card card)
    {
        c = card;
    }
    public void setButton(JButton inButton)
    {
        button1=inButton;
    }
    public void setSecondButton(JButton inButton)
    {
        button2=inButton;
    }
    public JButton getButton()
    {
        return button1;
    }
    public JButton getSecondButton()
    {
        return button2;
    }
    public void endGame(int moves, int time, String difficulty)
    {
        GameEndDisplay end = new GameEndDisplay(moves, time, difficulty);
        end.createDisplay();
    }
}
