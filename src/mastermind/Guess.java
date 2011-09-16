package mastermind;
import mastermind.ColorCombination;

public class Guess {
	public ColorCombination colorCombination;
	public Hint hint;

	public Guess( String correctCombination, String guessedCombination ) {
		colorCombination = new ColorCombination(guessedCombination);
		hint = new Hint(correctCombination, guessedCombination);
		hint.calculateHint();
	}
}