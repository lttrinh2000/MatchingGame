import java.util.Scanner;

public class TerminalDriver
{
    public static void main(String []args)
    {
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        int moves = 0;

        System.out.println("Choose a difficulty: (E)asy (M)edium or (H)ard");
        String difficulty = scan.nextLine();

        if (difficulty.equalsIgnoreCase("E") || difficulty.equalsIgnoreCase("M") || difficulty.equalsIgnoreCase("H"))
            deck.setDifficulty(difficulty.charAt(0));
        else
            System.out.println("Invalid Input");

        String firstChoice,secondChoice;

        while(true)//(deck.cardsLeft()>0) not a real method
        {
            deck.display();

            System.out.println("Pick a letter: ");
            firstChoice = scan.nextLine();
            Card card1 = deck.findLetter(firstChoice.charAt(0));
            System.out.println(card1.getValue());

            System.out.println("Pick a letter: ");
            secondChoice = scan.nextLine();
            Card card2 = deck.findLetter(secondChoice.charAt(0));
            System.out.println(card2.getValue());

            moves++;
            if (card1.compare(card2))
            {
                deck.removeCard(card1);
                deck.removeCard(card2);
            }
            else
                System.out.println("Mismatch");
        }

        //scan.close();
    }
}
