import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    Random randomGenerator;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private char [] letters;
    private int [] values;
    private int numCards;

    public Deck()
    {
        for (int i = 1; i <= 2; i++)
        {
            for (int j = 1; j <= numCards/2; j++)
            {
                values[i] = j;
                letters[i] = (char)(65 + (i*j-1));
            }
        }
        shuffle();
        for (int k = 0; k < numCards; k++)
        {
            cards.add(new Card(values[k], letters[k]));
        }
    }

    public void setDifficulty(char d)
    {
        if (d == 'e' | d == 'E')
        {
            System.out.println("User chose: "+ d);
            numCards = 4;
        }
        else if (d == 'm' | d == 'M')
        {
            System.out.println("User chose: "+ d);  
            numCards = 6;
        }
        else if (d == 'h' | d == 'H')
        {
            System.out.println("User chose: "+ d);
            numCards = 8;
        }
        else
        {
            System.out.println("User chose: "+ d);  
            numCards = 6;
        }
    }

    private void shuffle()
    {
        Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<values.length; i++) {
		    int randomPosition = rgen.nextInt(values.length);
		    int temp = values[i];
		    values[i] = values[randomPosition];
		    values[randomPosition] = temp;
		}
    }
    

    public void display()
    {
        String tag;
        for(int i = 0; i <= numCards; i++)
        {
            if (i%2==0)
                tag = "\t";
            else
                tag = "\n";
            System.out.println(cards.get(i)+tag);
        }
    }

    public void removeCard(Card c)
    {
        for (Card x : cards)
        {
            if (x.getValue() == c.getValue() & x.getLetter() == c.getLetter())
            {
                cards.remove(x);
            }
        }
    }

    public Card findLetter(char c)
    {
        for (Card x : cards)
        {
            if (x.getLetter() == c)
            {
                return x;
            }
        }
        System.out.println("Letter not found.");
        return null;
    }

}