package model;

public class Card
{
    protected int value;
    protected char letter;

    public Card(int value, char letter)
    {
        this.value = value;
        this.letter = letter;
    }

    public int getValue()
    {
        return this.value;
    }

    public char getLetter()
    {
        return this.letter;
    }

    public boolean compare(Card c)
    {
        if (c.getValue() == this.getValue())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
