import java.util.Scanner;

public class TerminalInput
{
    /**
     * Use Case 1: Choose difficulty level
     */
  
    public static void userChoices(Deck d)
    {
        Scanner s = new Scanner(System.in);

	while (true)
        {
            System.out.println("Choose a difficulty: E M H");
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

		/**
		 * Use Case 2: Save highest score and print out current highest score
		 */

		Highscore score = new Highscore();
		int currentScore = score.getHighscore("save_highscore.csv");
		System.out.println("Current highest score is: " + currentScore);

		System.out.println("Please enter your name: ");
                String name = n.nextLine();

		int move = 0;
		while (true) 
		{
			if(d.allEmpty() == true) {
				System.out.println("Game END");
				System.out.println("Your score is: "+ move);

                                if(move <= currentScore) {
                                        score.saveHighscore(name,Integer.toString(move));
                                }
                                break;
                        }

			d.display();

			/**
			 * Uses Case 3: Allow User to choose 2 cards and compare them
			 */

			System.out.println("Enter 1st card: ");
			String firstCard = t1.nextLine();

			System.out.println("Enter 2nd card: ");
			String secondCard = t2.nextLine();

			Card a = d.findLetter(firstCard);
			Card b = d.findLetter(secondCard);
			System.out.println("First Card have value: " + a.getValue());
			System.out.println("Second Card have value: " + b.getValue());
			
			move++;
		
			if(a.compare(b) == false) {
				System.out.println("\n" + "Don't match" +"\n");
				continue;
			}
			
			else {
				a.setLetter(' ');
				b.setLetter(' ');
			}
			continue;

		}
	}

}

