import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {
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
}