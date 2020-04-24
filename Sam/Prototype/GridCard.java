import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class GridCard extends JPanel
{
	//protected int row;
	//protected int col;
	//JFrame frame = new JFrame();
	//JPanel panel = new JPanel();

	public GridCard(int row, int col, Driver main, Prototype Proto){
		int numCard = row*col;

		this.setLayout(new GridLayout(row,col,10,10));

		Card card = new Card(Card.Type.centerCircle,1);
		CardIcon icon = new CardIcon(150,card);

		for (int i=1; i<= numCard; i++) {
			JButton button = new JButton("Card "+ Integer.toString(i));
			button.setIcon(icon);
			button.setPreferredSize(new Dimension(150, 150));
			button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if (main.cardSelected()==false)
					{
						button.setEnabled(false);
						main.switchSelected();
						main.setButton(button);
					}
					else
					{
						if (main.getCard().getType()==Card.Type.centerCircle)//placeholder
						{
							System.out.println("Cards match");
							button.setEnabled(false);							
						}
						else
						{
							System.out.println("Cards dont match");
							main.getButton().setEnabled(true);
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
