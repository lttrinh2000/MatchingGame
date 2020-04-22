import java.awt.event.*;
public class MemoryController
{
    protected Deck deck;
    protected CardTable cardTable;

    protected ActionListener flipOneListener;
    protected ActionListener flipTwoListener;

    public MemoryController(deck, cardTable)
    {
        this.deck = deck;
        this.cardTable = cardTable;

        flipOneListener = new ActionListener(){
        public void actionPerformed(ActionEvent e)
            {
               flipOne();
            }
        };
        flipTwoListener = new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
               flipTwo();
            }
        };

        this.cardTable.setOnFlip(flipListener);
    }

    private void flipOne()
    {
        cardTable.flipCard();
    }
    private void flipTwo()
    {
        cardTable.flipCard();
    }

    public void startGame()
    {
    }
}