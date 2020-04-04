import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Deck
{
    Random randomGenerator;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private char [] letters;
    private ArrayList<Integer> values = new ArrayList<Integer>();
    private int numCards;
    private String diff;

    public void setDifficulty(char d)
    {
	
        if (d == 'e' | d == 'E')
        {
            System.out.println("User chose: Easy");
	    diff = "Easy";
            this.numCards = 4;
        }
        else if (d == 'm' | d == 'M')
        {
            System.out.println("User chose: Medium");
	    diff = "Medium";  
            this.numCards = 6;
        }
        else if (d == 'h' | d == 'H')
        {
            System.out.println("User chose: Hard");
	    diff = "Hard";
            this.numCards = 8;
        }
        else
        {
            System.out.println("User chose: Medium(default)");  
            this.numCards = 6;
        }
	
	int count=0;
	for (int i = 1; i <= numCards/2; i++)
        {
		//Card c = new Card(i,'A');
 		//cards.add(c);

		values.add(i);		

		if (i == numCards/2) {
			i=0;
			count++;
		}
		if (count == 2)
			break;
        }
	
	Collections.shuffle(values);

        for (int k = 0; k < numCards; k++)
        {
		//cards.get(k).setLetter((char)(65 + k));
		Card c = new Card(values.get(k),(char)(65 + k));
		cards.add(c);
        }
    }

    /*private void shuffle()
    {
        Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<values.size(); i++) {
		    int randomPosition = rgen.nextInt(values.size());
		    int temp = values.get(i);
		    values.get(i) = values.get(randomPosition);
		    values.get(randomPosition) = temp;
		}
    }*/
    
	public String getDiff() {
		return diff;
	}

    public void display()
    {
        String tag = " ";

	for(int i = 0; i < cards.size(); i++)
        {
	    if (i == (cards.size()/2)-1)
		tag = "\n";

            System.out.print(cards.get(i).getLetter() +tag);
	    tag = " ";
        }
	System.out.print("\n");
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

    public Card findLetter(String c)
    {	
	c = c.toUpperCase();	
        for (Card x : cards)
        {
            if (x.getLetter() == c.charAt(0))
            {
                return x;
            }
        }
        System.out.println("Letter not found.");
        return null;
    }

	public int length() {
		return cards.size();
	}

	public boolean allEmpty() {
		char first = cards.get(0).getLetter();
		for (int i=1; i<numCards; i++) {
			if(cards.get(i).getLetter() != first)
				return false;
		}
		return true;
	}
}
