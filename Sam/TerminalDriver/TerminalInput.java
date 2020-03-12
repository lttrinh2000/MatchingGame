import java.util.Scanner;
/**
 * User Interface via terminal
 */

public class TerminalInput
{
    public static void userChoices(Deck d)
    {
        Scanner s = new Scanner(System.in);

	while (true)
        {
            System.out.println("Choose a difficulty: (E)asy, (M)edium, or (H)ard: ");
            String userInput = s.nextLine();

            if (userInput.startsWith("e") || userInput.startsWith("E"))
            {
                d.setDifficulty(userInput.charAt(0));
				break;
            }

            else if (userInput.startsWith("m") || userInput.startsWith("M"))
            {
                d.setDifficulty(userInput.charAt(0));                                                                                             
				break;
			}
			
			else if (userInput.startsWith("h") || userInput.startsWith("H"))
			{
					d.setDifficulty(userInput.charAt(0));                                                                                             
					break;                                                                                                             
			}

			else
			{
			System.out.println("Please enter: E M H");
			}

		}
    }

	
	public static void userChooseCard(Deck d) {
		Scanner n = new Scanner(System.in);
		Scanner t1 = new Scanner(System.in);
		Scanner t2 = new Scanner(System.in);

		Highscore score = new Highscore();
		int currentScore = score.getHighscore("save_highscore.csv");
		System.out.println("Current highest score is: " + currentScore);

		System.out.println("Please enter your name: ");
        String name = n.nextLine();

		int move = 0;
		while (true) 
		{
			if(d.cardsLeft() == 0) 
			{
				System.out.println("You Win!");
				System.out.println("Your score is: "+ move);

                if(move <= currentScore)
            		score.saveHighscore(name,Integer.toString(move));
                break;
            }

			d.display();

			System.out.println("Enter 1st card: ");
			String firstCard = t1.nextLine();
			Card a = d.findLetter(firstCard.charAt(0));
			System.out.println(a.getLetter() + "'s value is: " + a.getValue());

			System.out.println("Enter 2nd card: ");
			String secondCard = t2.nextLine();
			Card b = d.findLetter(secondCard.charAt(0));
			System.out.println(b.getLetter() + "'s value is: " + b.getValue());
			
			move++;
		
			if(a.compare(b))
			{
				System.out.println("\n" + a.getLetter() + " and " + b.getLetter() + " match! " +"\n");
				d.removeCard(a);
				d.removeCard(b);
			}
			else 
			{
				System.out.println("\n" + a.getLetter() + " and " + b.getLetter() + " don't match. " +"\n");
			}

			System.out.println("Cards left = " + d.cardsLeft());

		}
	}

	public boolean playAgain()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to play again? (y/n): ");
		String playAgain = scan.nextLine();
		if(playAgain.equalsIgnoreCase("Y"))
			return true;
		else
			return false;
	}

}

