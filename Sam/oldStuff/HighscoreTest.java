import org.junit.*;
import static org.junit.Assert.*;

public class HighscoreTest {
	static Highscore score = new Highscore();

	public static void main(String[] args) {
		score.saveHighscore("Initial Test",100,"save.csv");
	}

	@Test
	public void saveHighscore_low() {
		score.saveHighscore("Test1",9,"save.csv");
		boolean result = score.isExecute();
		assertEquals(true, result);
	}

	@Test
        public void saveHighscore_equal() {
                score.saveHighscore("Test2",100,"save.csv");
                boolean result = score.isExecute();
                assertEquals(true, result);
        }

	@Test
        public void saveHighscore_high() {
                score.saveHighscore("Test3",999,"save.csv");
                boolean result = score.isExecute();
                assertEquals(false, result);
        }
	
}
