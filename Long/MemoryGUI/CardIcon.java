import java.awt.Rectangle;
import javax.swing.*;
import java.awt.*;

public class CardIcon implements Icon
{
    protected int width;
    protected int height;
    protected Card card;
    protected boolean showFace;
    protected String typeString = "";
    protected Color color;
    
    public CardIcon(int width, Card c)
    {
        this.showFace = true;
        this.width = width;
        this.height = width;
        this.card = c;
           
        Card.Type type = card.getType();
        switch (type)
        {
            case fillSquare:
                this.typeString = "\u25A0";
                break;
            case centerSquare:
                this.typeString = "\u25A3";
                break;
            case polkaSquare:
                this.typeString = "\u25A9";
                break;
            case fillTriangle:
                this.typeString = "\u25B2";
                break;
            case dotTriangle:
                this.typeString = "\u25EC";
                break;
            case centerCircle:
                this.typeString = "\u25C9";
                break;
            case linesCircle:
                this.typeString = "\u25CD";
                break;
        }
    }

    public void setShowFace(boolean showFace) 
    {
        this.showFace = showFace;
    }

    @Override
    public int getIconWidth()
    {
        return this.width;
    }

    @Override
    public int getIconHeight()
    {
        return this.height;
    }

    @Override public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);
        g2.fillRect(x,y,this.width,this.height);

        g2.setColor(Color.BLACK);
        Rectangle r = new Rectangle(this.width, this.height);
        g2.draw(r);

        if (this.showFace)
        {
            g2.setFont(new Font("Symbola",Font.PLAIN,this.height-this.height/4));
            g2.setColor(this.color);
            g2.drawString(typeString, x+this.width/2-this.width/3, y+this.height-this.height/4);
        }
        else
        {
            for(x = 2; x<this.width; x=x+(width/10))
            {
                for(y=2;y<this.height;y=y+(height/10))
                {
                    g2.setColor(Color.BLUE);
                    g2.fillRect(x, y, width/20, height/20);
                }
           }
        } 
    }
}