import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class Deck
{
    Random randomGenerator;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int numColors;
    
    
    public int getNumCards() {
	return numColors;
    }


    public void buildDeck()
    {
        for (int i = 1; i <= 2; i++)
        {
            for(int j = 1; j <= numColors; j++)
            {
                cards.add(new Card(Card.Type.fillSquare, j));
                cards.add(new Card(Card.Type.centerSquare, j));
                cards.add(new Card(Card.Type.polkaSquare, j));
                cards.add(new Card(Card.Type.fillTriangle, j));
                cards.add(new Card(Card.Type.dotTriangle, j));
                cards.add(new Card(Card.Type.centerCircle, j));
                cards.add(new Card(Card.Type.linesCircle, j));
            }
        }
    }

    public void setDifficulty(char d)
    {
        //Determine number of cards in deck
        if (d == 'e' | d == 'E')
        {
            System.out.println("User chose: "+ d);
            numColors = 1;
        }
        else if (d == 'm' | d == 'M')
        {
            System.out.println("User chose: "+ d);  
            numColors = 2;
        }
        else if (d == 'h' | d == 'H')
        {
            System.out.println("User chose: "+ d);
            numColors = 3;
        }
        else
        {
            System.out.println("User chose: "+ d);
            System.out.println("Invalid input. Defaulting to medium.");  
            numColors = 2;
        }

        buildDeck();
    }
    public void shuffle()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            int swap_with = randomGenerator.nextInt(cards.size());
            Card swapped = cards.get(i);
            cards.set(i,cards.get(swap_with));
            cards.set(swap_with, swapped);
        }
    }
    public void removeCard(Card c)
    {
        cards.remove(c);
    }

    public int cardsLeft()
    {
        return cards.size();
    }
}
