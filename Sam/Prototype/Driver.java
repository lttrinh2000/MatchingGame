import javax.swing.*; 

public class Driver
{
    boolean selected=false;
    Card c = new Card(Card.Type.centerCircle,1);
    JButton button;

    public static void main(String []args)
    {
        Prototype memoryPrototype = new Prototype(400,new Driver());

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
    public void setButton(JButton inButton)
    {
        button=inButton;
    }
    public JButton getButton()
    {
        return button;
    }
    public void newGame(String difficulty)
    {
        Prototype memoryPrototype = new Prototype(400,new Driver());
    }

}