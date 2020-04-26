package view;
import model.*;
import controller.*;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.lang.Math;

public class GridCard extends JPanel
{
	private int numCard;

    public GridCard(Deck d, GameBoard Proto)
    {
		numCard = d.getSize();

		int row = (int)(Math.ceil(Math.sqrt((double)numCard)));
		int col = (int)(Math.floor(Math.sqrt((double)numCard)));

		this.setLayout(new GridLayout(row,col,10,10));

        for (int i=0; i< numCard; i++)
        {
			Card card = d.getCard(i);
			CardIcon icon = new CardIcon(125,card);

			JButton button = new JButton("Card "+ Integer.toString(i+1));
			button.setIcon(null);
			button.setPreferredSize(new Dimension(125, 125));
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (Proto.cardSelected()==false)
					{
						// hides old selected
						Proto.getButton().setIcon(null);
						Proto.getSecondButton().setIcon(null);

						//selects a card, disables button, and changes appropriate fields
						button.setEnabled(false);
						Proto.switchSelected();
						Proto.setButton(button);
						Proto.setCard(card);
						button.setIcon(icon);
					}
					else
					{
						if (Proto.getCard().compare(card))
						{
							button.setEnabled(false);
							button.setIcon(icon);	
							button.setBackground(Color.GREEN);
							Proto.getButton().setIcon(new CardIcon(125, Proto.getCard()));
							Proto.getButton().setBackground(Color.GREEN);
							Proto.setButton(new JButton("Placeholder"));
							Proto.setSecondButton(new JButton("Placeholder"));
							numCard = numCard -2;
							if (numCard==0)
							{
								int timeLeft = Proto.stopTime();
								Proto.endGame(Proto.getMoves(), (60-timeLeft), Proto.getDifficulty(), Proto);
							}
						}
						else
						{
							button.setIcon(icon);
							Proto.getButton().setEnabled(true);
							Proto.setSecondButton(button);	
						}
						Proto.switchSelected();
						Proto.updateScore();
					}
					Proto.mainFrame.pack();
				}
			});
			this.add(button);
		}
	}
}
