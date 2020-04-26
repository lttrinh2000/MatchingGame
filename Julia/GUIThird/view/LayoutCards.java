package view;

import model.*;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.lang.Math;

public class LayoutCards extends JPanel
{
    private int numCard;

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
            CardIcon icon = new CardIcon(120, card);
            JButton cardButton = new JButton("Card " + Integer.toString(i));
            cardButton.setIcon(null);
            cardButton.setPreferredSize(new Dimension(120,120));
            //this.add(cardButton);
            cardButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
				{
					if (cardSelected()==false)
					{
						// hides old selected
						getButton().setIcon(null);
						getSecondButton().setIcon(null);

						//selects a card, disables button, and changes appropriate fields
						cardButton.setEnabled(false);
						switchSelected();
						setButton(cardButton);
						setCard(card);
						cardButton.setIcon(icon);
                    }
                    else
                    {
                        if (getCard().compare(card))
                        {
                            cardButton.setEnabled(false);
							cardButton.setIcon(icon);	
							cardButton.setBackground(Color.GREEN);
							getButton().setIcon(new CardIcon(120, getCard()));
							getButton().setBackground(Color.GREEN);
							setButton(new JButton("Placeholder"));
							setSecondButton(new JButton("Placeholder"));
							numCard = numCard -2;
							if (numCard==0)
							{
								//int timeLeft = Proto.stopTime();
								//main.endGame(Proto.getMoves(), (60-timeLeft), Proto.getDifficulty());
                            }
                        }
                        else
						{
							cardButton.setIcon(icon);
							getButton().setEnabled(true);
							setSecondButton(cardButton);	
                        }
                        switchSelected();
                        //Proto.updateScore();
                    }
                }
            });
            this.add(cardButton);

        }
    }

    // Interacting with this class from outside of the class
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
