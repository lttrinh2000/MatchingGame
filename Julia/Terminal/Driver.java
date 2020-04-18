public class Driver
{
    public static void main(String []args)
    {
        TerminalInput t = new TerminalInput();
        boolean play = true;

        while(play)
        {
            Deck deck = new Deck();
            int moves = 0;
            t.beginGame(deck);
            Timer time = new Timer();
            while(deck.cardsLeft() > 0)
            {
                if (time.getTime() > 45)
                {
                    System.out.println("You ran out of time.");
                    moves = 1000000;
                    break;
                }
                System.out.println("Time Left: " + (45 - time.getTime()) + " seconds");
                deck.display();
                t.userChooseCard(deck);
                moves++;
            }
            long userTime = time.getTime();
            t.endGame(moves);
            System.out.println("Your Time: " + userTime + " seconds");

            play = t.playAgain();
        }        
    }
}