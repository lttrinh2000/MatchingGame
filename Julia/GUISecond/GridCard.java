import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.lang.Math;

public class GridCard extends JPanel
{
	private int numCard;

    public GridCard(Deck d, Driver main, GameBoard Proto)
    {
		numCard = d.getSize();

		int row = (int)(Math.ceil(Math.sqrt((double)numCard)));
		int col = (int)(Math.floor(Math.sqrt((double)numCard)));

		this.setLayout(new GridLayout(row,col,10,10));

        for (int i=0; i< numCard; i++)
        {
			Card card = d.getCard(i);
			CardIcon icon = new CardIcon(150,card);

			JButton button = new JButton("Card "+ Integer.toString(i));
			button.setIcon(null);
			button.setPreferredSize(new Dimension(150, 150));
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (main.cardSelected()==false)
					{
						// hides old selected
						main.getButton().setIcon(null);
						main.getSecondButton().setIcon(null);

						//selects a card, disables button, and changes appropriate fields
						button.setEnabled(false);
						main.switchSelected();
						main.setButton(button);
						main.setCard(card);
						button.setIcon(icon);
					}
					else
					{
						if (main.getCard().compare(card))
						{
							button.setEnabled(false);
							button.setIcon(icon);	
							button.setBackground(Color.GREEN);
							main.getButton().setIcon(new CardIcon(150, main.getCard()));
							main.getButton().setBackground(Color.GREEN);
							main.setButton(new JButton("Placeholder"));
							main.setSecondButton(new JButton("Placeholder"));
							numCard = numCard -2;
							if (numCard==0)
							{
								int timeLeft = Proto.stopTime();

							}
						}
						else
						{
							button.setIcon(icon);
							main.getButton().setEnabled(true);
							main.setSecondButton(button);	
						}
						main.switchSelected();
						Proto.updateScore();
					}
				}
			});
			this.add(button);
		}
	}
}
