package mastermind;

import java.util.ArrayList;
import mastermind.Guess;
import mastermind.ColorCombination;

public class Board {
	private int numberOfPins;
	private int numberOfAttempts;
	private ColorCombination rightCombination;
	public Game is_played_on;
	public ArrayList<Guess> attempt = new ArrayList<Guess>();
	public ArrayList<ColorCombination> correct_combination = new ArrayList<ColorCombination>();

	public Board(int numberOfPins, int numerOfAttempts) {
		throw new UnsupportedOperationException();
	}

	public void generateNewCombination() {
		throw new UnsupportedOperationException();
	}

	public void checkColorCombination(ColorCombination cc) {
		throw new UnsupportedOperationException();
	}

	public void createNewGuess(Guess guess) {
		throw new UnsupportedOperationException();
	}
}