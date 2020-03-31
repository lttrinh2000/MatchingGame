import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class GridCard extends JPanel{
	//protected int row;
	//protected int col;
	//JFrame frame = new JFrame();
	//JPanel panel = new JPanel();

	public GridCard(int row, int col){
		int numCard = row*col;

		this.setLayout(new GridLayout(row,col,10,10));

		Card card = new Card(Card.Type.centerCircle,1);
		CardIcon icon = new CardIcon(150,card);

		for (int i=1; i<= numCard; i++) {
			JButton button = new JButton("Card "+ Integer.toString(i));
			button.setIcon(icon);
			button.setPreferredSize(new Dimension(150, 150));

			this.add(button);
		}

		/*frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true); */
	}
}
