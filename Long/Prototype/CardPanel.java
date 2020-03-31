import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class CardPanel extends JPanel
{
    private int width;
    private JPanel cards;

    public CardPanel(int width)
    {
        this.setBackground(Color.BLUE);
        this.width = width;
        cards = new JPanel();
        cards.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(cards, BorderLayout.CENTER);
    }

    public void clearCards()
    {
        cards.removeAll();
    }

    public void add(Card card, boolean show)
    {
        CardIcon cardIcon = new CardIcon(width/5, card);
        cardIcon.setShowFace(show);
        JLabel cardLabel = new JLabel(cardIcon);

        cards.add(cardLabel);
        cards.revalidate();
        cards.repaint();
    }
}