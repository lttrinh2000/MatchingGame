public class Driver {
	/**
	 * Please look at TerminalInput.java for demonstrate of use cases
	 */

	public static void main(String[] args) {
		Deck d = new Deck();
		TerminalInput input = new TerminalInput();
		input.userChoices(d);
		input.userChooseCard(d);
	}

}
