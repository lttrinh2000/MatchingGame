package model;

public class Card
{
    enum Type {fillSquare, centerSquare, polkaSquare, fillTriangle,
                dotTriangle, centerCircle, linesCircle}
    
    protected Type type;
    protected int colorNum;

    public Card(Type t, int j)
    {
        this.type = t;
        this.colorNum = j;  
    }
    public int getColorNumber()
    {
        return this.colorNum;
    }
    public Type getType()
    {
        return this.type;
    }
    public boolean compare(Card c)
    {
        if (c.getColorNumber() == this.getColorNumber() & c.getType() == this.getType())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}