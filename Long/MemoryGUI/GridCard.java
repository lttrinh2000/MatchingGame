
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class GridCard extends JPanel{

	public GridCard(Deck d){
		int numCards = d.getNumCards()*d.getNumCards();

		this.setLayout(new GridLayout(d.getNumCards(),d.getNumCards(),10,10));

		Card card = new Card(Card.Type.centerCircle,1);
		CardIcon icon = new CardIcon(150,card);

		for (int i=1; i<= numCards; i++) {
			JButton button = new JButton("Card "+ Integer.toString(i));
			button.setIcon(icon);
			button.setPreferredSize(new Dimension(150, 150));

			this.add(button);
		}

	}
}
