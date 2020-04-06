import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class Deck
{
    Random randomGenerator;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Character> letters = new ArrayList<Character>();
    private ArrayList<Integer> values = new ArrayList<Integer>();
    private int numCards;

    public void buildDeck()
    {
        for (int i = 0; i < numCards/2; i++)
        {
            values.add(i);
            values.add(i);
        }

        System.out.println(values.size());
        Collections.shuffle(values);

        for (int k = 0; k < numCards; k++)
        {
            cards.add(new Card(values.get(k).intValue(), (char)(65+k)));
        }
    }

    public void setDifficulty(char d)
    {
        //Determine number of cards in deck
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
            System.out.println("Not acceptable input. Defaulting to medium.");  
            numCards = 6;
        }

        buildDeck();
    }  

    public void display()
    {
        System.out.println("\nYour Deck:");
        for(int i = 0; i < numCards; i++)
        {
            System.out.print(cards.get(i).getLetter()+" ");
        }
        System.out.println("\n");
    }

    public void removeCard(Card c)
    {
        cards.remove(c);
        numCards--;
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

    public int cardsLeft()
    {
        return cards.size();
    }

}