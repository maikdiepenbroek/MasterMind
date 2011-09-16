package mastermind;

import java.util.ArrayList;
import mastermind.Guess;
import mastermind.ColorCombination;

public class Board {
	private int numberOfPins;
	private int numberOfAttempts;
	private ColorCombination rightCombination;
	public Game game;
	public ArrayList<Guess> attempts = new ArrayList<Guess>();
	public ColorCombination correctCombination;

	public Board(int numberOfPins, int numerOfAttempts) {
		throw new UnsupportedOperationException();
	}

	public void generateNewCombination() {
		throw new UnsupportedOperationException();
	}

	public void checkColorCombination(ColorCombination colorCombination) {
		throw new UnsupportedOperationException();
	}

	public void createNewGuess(String guess) {
		Guess attempt = new Guess(guess);
		attempts.add(attempt);
	}
	
	public void setRightColorCombination(ColorCombination newColorCombination) {
		rightCombination = newColorCombination;
	}
}