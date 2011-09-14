package mastermind;

import java.util.ArrayList;

public class Board {
	private ArrayList<ColorCombination> guessedCombination;
	private ArrayList<Hint> hintList;
	public Player player;
	public Game game;
	
	public ColorCombination colorCombination;

	public void generateNewCombination() {
		
	}

	public void checkColorCombination(ArrayList<ColorCombination> aCc) {
		
	}

	public void setGuessedCombination(ArrayList<ColorCombination> guessedCombination) {
		this.guessedCombination = guessedCombination;
	}

	public ArrayList<ColorCombination> getGuessedCombination() {
		return guessedCombination;
	}

	public void setHintList(ArrayList<Hint> hintList) {
		this.hintList = hintList;
	}

	public ArrayList<Hint> getHintList() {
		return hintList;
	}
}