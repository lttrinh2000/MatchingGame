import model.*;
import controller.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DeckTest 
{
    @Test
    public void setEasyExpectTrue()
    {
        Deck d = new Deck();
        d.setDifficulty('E');
        int numExpected = 4;
        boolean result = (numExpected==d.cardsLeft());
        assertEquals("setEasyExpectTrue() ", true, result);
    }

    @Test
    public void setMediumExpectTrue()
    {
        Deck d = new Deck();
        d.setDifficulty('M');
        int numExpected = 6;
        boolean result = (numExpected==d.cardsLeft());
        assertEquals("setMediumExpectTrue() ", true, result);
    }

    @Test
    public void setHardExpectTrue()
    {
        Deck d = new Deck();
        d.setDifficulty('H');
        int numExpected = 8;
        boolean result = (numExpected==d.cardsLeft());
        assertEquals("setHardExpectTrue() ", true, result);
    }

    @Test
    public void removeCardExpectTrue()
    {
        Deck d = new Deck();
        d.setDifficulty('M');
        int numExpected = 5;
        Card A = d.findLetter('A');
        d.removeCard(A);
        boolean result = (numExpected==d.cardsLeft());
        assertEquals("removeCardExpectTrue() ", true, result);
    }

}