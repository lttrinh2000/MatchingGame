
import model.*;

import org.junit.*;
import static org.junit.Assert.*;

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
    public void getTimeExpect5()
    {
        Timer timer = new Timer();
        try
        {
            Thread.sleep(5);
        }
        catch(InterruptedException E)
        {
            System.out.println("Error");
        }
        assertEquals(5,(int)timer.getTimeMilli());
    }
}