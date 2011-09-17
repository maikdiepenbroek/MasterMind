package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import mastermind.Guess;
import mastermind.ColorCombination;

/*
 * Check for number of entered colors
 * make input uppercase
 * check for invalid colors
 */

public class Board {
	private int numberOfPins, numberOfAttempts, attemptsMade = 0;
			
	public ArrayList<Guess> attempts = new ArrayList<Guess>();
	public ColorCombination correctCombination;

	public Board(int numberOfPins, int numberOfAttempts) {
		this.numberOfPins 	  = numberOfPins;
		this.numberOfAttempts = numberOfAttempts;
		
		System.out.println("Board has been set up.");
	}
	
	public String askForNewCombination() {
		System.out.println("Enter a new combination: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String givenColorCombination = null;

		try {
			givenColorCombination = br.readLine();
		}
		catch(IOException ioe) {
			System.out.println("Error receiving the input");
			System.exit(1);
		}
		return givenColorCombination;
	}

	public void generateNewCombination() {
		StringBuffer secretCombination = new StringBuffer();
		char[] availableColors = {'R', 'G', 'B', 'Y'};
		
		for(int i = 0; i < numberOfPins; i++) {
			int randomNumber = (int) Math.round(Math.random()*(availableColors.length-1));
			secretCombination.append(availableColors[randomNumber]);
		}
		
		correctCombination = new ColorCombination(secretCombination.toString());
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
		
	public int getNumberOfAttempts() {
		return this.numberOfAttempts;
	}
	
	public int getAttemptsMade() {
		return this.attemptsMade;
	}

	public void increaseNumberOfAttemptsMade(){
		this.attemptsMade++;
	}

	public ArrayList<Guess> getAttempts() {
		return attempts;
	}

	public void setAttempts(ArrayList<Guess> attempts) {
		this.attempts = attempts;
	}
		
}