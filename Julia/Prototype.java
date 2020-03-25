import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

public class Prototype
{
    private int frameSize = 400;
    private JFrame mainFrame;

    public Prototype(int size)
    {
        this. frameSize = size;

        mainFrame = new JFrame("Memory Game");
        mainFrame.setPreferredSize(new Dimension(frameSize, frameSize*3/2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel table = new JPanel();
        table.setLayout(new BoxLayout(table, BoxLayout.Y_AXIS));

        CardPanel cardRows = new CardPanel(frameSize);
        cardRows.add(new Card(Card.Type.centerCircle, 1), true);
        cardRows.add(new Card(Card.Type.centerCircle, 1), true);

        table.add(cardRows);

        mainFrame.add(table);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JFrame getFrame()
    {
        return mainFrame;
    }
}