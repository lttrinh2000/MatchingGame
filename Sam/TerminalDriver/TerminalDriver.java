import java.util.Scanner;

public class TerminalDriver
{
    public static void main(String []args)
    {
        TerminalInput userInput = new TerminalInput();
        boolean play = true;

        while(play)
        {
            Deck deck = new Deck();
            userInput.userChoices(deck);
            userInput.userChooseCard(deck);
            play = userInput.playAgain();
        }

    }
}