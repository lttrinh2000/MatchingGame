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

    public Type getType()
    {
        return this.type;
    }
}
