package mastermind;

public class Guess {
	private ColorCombination colorCombination;
	private Hint hint;

	public Guess(final String correctCombination, final String guessedCombination ) {
		this.colorCombination = new ColorCombination(guessedCombination);
		this.hint = new Hint(correctCombination, guessedCombination);
		this.hint.calculateHint();
	}
	
	public final ColorCombination getColorCombination() {
		return this.colorCombination;
	}

	public final void setColorCombination(final ColorCombination newColorCombination) {
		this.colorCombination = newColorCombination;
	}

	public final Hint getHint() {
		return this.hint;
	}

	public final void setHint(final Hint newHint) {
		this.hint = newHint;
	}
}
