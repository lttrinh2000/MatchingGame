package view;

import model.*;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.lang.Math;

public class LayoutCards extends JPanel
{
    private int numCard;
    private JButton cardButton;

    private JButton button1 = new JButton("Placeholder");
    private JButton button2 = new JButton("Placeholder");
    private Card c;
    private boolean selected = false;

    public LayoutCards(Deck d)
    {
        numCard = d.getSize();

        int row = (int)(Math.ceil(Math.sqrt((double)numCard)));
        int col = (int)(Math.floor(Math.sqrt((double)numCard)));
        this.setLayout(new GridLayout(row,col,10,10));

        for (int i=0; i<numCard; i++)
        {
            Card card = d.getCard(i);
            CardIcon icon = new CardIcon(150, card);
            cardButton = new JButton("Card " + Integer.toString(i));
            cardButton.setIcon(null);
            cardButton.setPreferredSize(new Dimension(150,150));
            this.add(cardButton);
        }
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

}