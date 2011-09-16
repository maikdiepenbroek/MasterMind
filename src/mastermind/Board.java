package mastermind;

import java.util.ArrayList;
import mastermind.Guess;
import mastermind.ColorCombination;

public class Board {
	private int numberOfPins;
	private int numberOfAttempts;
	public ArrayList<Guess> attempts = new ArrayList<Guess>();
	public ColorCombination correctCombination;

	public Board(int numberOfPins, int numerOfAttempts) {
		this.numberOfPins 	  = numberOfPins;
		this.numberOfAttempts = numberOfAttempts;
	}

	public void generateNewCombination() {
		correctCombination = new ColorCombination("RGBB");
	}

	public void checkColorCombination(ColorCombination colorCombination) {
		throw new UnsupportedOperationException();
	}

	public void createNewGuess(String guessedCombination) {
		Guess attempt = new Guess(correctCombination.returnColorCombinationAsString(),
								  guessedCombination);
		attempts.add(attempt);
	}
	
	public void setRightColorCombination(ColorCombination newColorCombination) {
		correctCombination = newColorCombination;
	}
}