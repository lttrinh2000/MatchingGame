package tests;

import org.junit.*;
import static org.junit.Assert.*;

import model.*;

public class MemoryTest
{
    @Test
    public void compareExpectTrue()
    {
        Card a = new Card(5, 'a');
        Card b = new Card(5, 'b');
        assertTrue(a.compare(b));
    }

    @Test
    public void compareExpectFalse()
    {
        Card a = new Card(5, 'a');
        Card b = new Card(6, 'b');
        assertFalse(a.compare(b));
    }

    @Test 
    public void removeCardTrue()
    {
        Deck deck = new Deck();
        deck.setDifficulty('e');
        deck.buildDeck();

        Card card = deck.findLetter('a');

        int beforeRemove = deck.cardsLeft();
        deck.removeCard(card);
        int afterRemove = deck.cardsLeft();

        assertEquals(4, beforeRemove);
        assertEquals(3, afterRemove);
    }

    @Test
    public void compareExpectRemove()
    {
        Deck deck = new Deck();
        deck.setDifficulty('e');
        deck.buildDeck();

        Card a = deck.findLetter('a');
        Card b = deck.findLetter('b');

        int beforeRemove = deck.cardsLeft();
        if (a.compare(b))
            deck.removeCard(card);
        int afterRemove = deck.cardsLeft();

        assertEquals(4, beforeRemove);
        assertEquals(3, afterRemove);
    }

    @Test
    public void compareNoRemove()
    {
        Deck deck = new Deck();
        deck.setDifficulty('e');
        deck.buildDeck();

        Card a = deck.findLetter('a');
        Card b = deck.findLetter('b');

        int beforeRemove = deck.cardsLeft();
        if (a.compare(b))
            deck.removeCard(card);
        int afterRemove = deck.cardsLeft();

        assertEquals(4, beforeRemove);
        assertEquals(4, afterRemove);
    }

    @Test 
    public void getTimeExpect5()
    {
        Timer timer = new Timer();
        Thread.sleep(5);
        assertEquals(5,(int)timer.getTime());
    }
}