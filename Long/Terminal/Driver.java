public class Driver {
	public static void main(String[] args) {
		Deck d = new Deck();
		/*d.setDifficulty('m');
		d.display();*/

		TerminalInput input = new TerminalInput();
		input.userChoices(d);
		input.userChooseCard(d);
	}

}
