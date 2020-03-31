import java.util.Scanner;
/**
 * User Interface via terminal
 */

public class TerminalInput
{
    protected int move;

    public static void userChoices()	//Deck d in parameter
    {
        Scanner s = new Scanner(System.in);

	while (true)
        {
            System.out.println("Choose a difficulty: E M H");
            String userInput = s.nextLine();

            if (userInput.startsWith("e") || userInput.startsWith("E"))
            {
                //d.dislay('e');
		System.out.println("User chose: E");
		break;
            }

            else if (userInput.startsWith("m") || userInput.startsWith("M"))
            {
                //d.dislay('m');
		System.out.println("User chose: M");
		break;
            }

	    else if (userInput.startsWith("h") || userInput.startsWith("H"))
	    {
                //d.dislay('h');
		System.out.println("User chose: H");
		break;                                                                                                             
	    }

	    else
	    {
		System.out.println("Please enter: E M H");
	    }

        }
    }

	
	public static void userChooseCard() {		// Deck d in paramenter
		Scanner n = new Scanner(System.in);
		Scanner t1 = new Scanner(System.in);
		Scanner t2 = new Scanner(System.in);

		while (true) 
		{
			System.out.println("Please enter your name: ");
			String name = n.nextLine();

			System.out.println("Enter 1st tile: ");
			String firstTile = t1.nextLine();

			System.out.println("Enter 2nd tile: ");
			String secondTile = t2.nextLine();
	
			break;

			/* Card a = d.findLetter(firstTile);
			Card b = d.findLetter(secondTile);
			System.out.println("First tile have value: " + a.getValue());
			System.out.println("Second tile have value: " + b.getValue()); */
			
			//move++

			/* if(a.compare(b) == false) {
				continue;
			}
			
			else {
				d.remove(a);
				d.remove(b);
				d.dislay();
			} */


			/* if(d.length() == 0)
				break;
			*/
		}
	}

	public static void main(String[] args) {
		TerminalInput input = new TerminalInput();
		input.userChoices();
		input.userChooseCard();
	}

}

