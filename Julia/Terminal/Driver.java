import java.util.Scanner;

public class Driver
{
    public static void main(String []args)
    {
        Deck deck = new Deck();
        TerminalInput t = new TerminalInput();
        int moves = 0;
        
        t.beginGame(deck);

        while(deck.cardsLeft() > 0)
        {
            deck.display();
            t.userChooseCard(deck);
            moves++;
        }

        t.endGame(moves);
    }
}