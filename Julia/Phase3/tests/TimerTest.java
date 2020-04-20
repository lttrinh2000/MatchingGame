import org.junit.*;
import static org.junit.Assert.*;

public class TimerTest {
    @Test 
    public void getTimeExpect5() throws InterruptedException
    {
        Timer timer = new Timer();
        Thread.sleep(5000);
        assertEquals(5,(int)timer.getTime());
    }
}