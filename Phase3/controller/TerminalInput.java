package controller;

import java.util.Scanner;
import model.*;

public class TerminalInput
{
	Scanner s = new Scanner(System.in);
	HighScore score = new HighScore();
	int currentScore = score.getHighScore("save_highscore.csv");

    public void beginGame(Deck d)
    {
		System.out.println("The current high score is: "+ currentScore);
		System.out.println("This score was set by: " + score.getHighScoreName("save_highscore.csv"));

		System.out.println("Choose a difficulty: (E)asy (M)edium or (H)ard: ");
        char userInput = s.nextLine().charAt(0);
        d.setDifficulty(userInput);
    }

	public void userChooseCard(Deck d)
	{
		System.out.println("Pick a card (enter letter): ");
        String firstChoice = s.nextLine();
        Card card1 = d.findLetter(firstChoice.toUpperCase().charAt(0));
        System.out.println(card1.getValue());

        System.out.println("Pick a second card (enter letter): ");
        String secondChoice = s.nextLine();
        Card card2 = d.findLetter(secondChoice.toUpperCase().charAt(0));
        System.out.println(card2.getValue());

		if (card1.compare(card2))
        {
			System.out.println("You found a match!");
            d.removeCard(card1);
            d.removeCard(card2);
        }
		else
		{
			System.out.println("Mismatch");
		}
	}

	public void endGame(int moves)
	{
		System.out.println("GAME COMPLETE");
		System.out.println("Your score is: " + moves + "\n");

		if(moves < currentScore) 
		{
			System.out.println("New High Score! Please enter your name: ");
			String name = s.nextLine();
			score.saveHighScore(name, String.valueOf(moves));
		}
		else if (moves == currentScore)
		{
			System.out.println("You Matched the High Score! So close!");
		}
		else
		{
			System.out.println("You did not get a high score.");
		}
	}

	public boolean playAgain()
	{
		System.out.println("Do you want to play again? (y/n): ");
		char playAgain = s.nextLine().toUpperCase().charAt(0);
		if(playAgain == 'Y')
			return true;
		else
			return false;
	}
}

