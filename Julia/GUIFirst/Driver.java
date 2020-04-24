
public class Driver 
{
    int time = 60;
    int moves = 14;
    int prevHigh = 17;
    String prevHighName = "Eric";

    GameEndDisplay endGame = new GameEndDisplay(time, moves, prevHigh, prevHighName);
    endgame.createDisplay();
    /*
    System.out.println(endGame.playAgain());
    System.out.println(endGame.newHighscore());
    System.out.println(endGame.newHighscoreName());
    */
}