package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Board {
	private int numberOfPins, numberOfAttempts, attemptsMade = 0;
			
	private ArrayList<Guess> attempts = new ArrayList<Guess>();
	private ColorCombination correctCombination;
	private String givenColorCombination = null;

	public Board(final int numberOfPinsToSet, final int numberOfAttemptsToSet) {
		this.numberOfPins 	  = numberOfPinsToSet;
		this.numberOfAttempts = numberOfAttemptsToSet;
		 
		System.out.println("Board has been set up.");
	}
	
	public final String askForNewCombination() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			boolean correctInput = false;
			
			while( !correctInput ) {
				System.out.println("Enter a new combination: ");
				String givenCombination = br.readLine().toUpperCase();
				this.givenColorCombination = givenCombination;
				if ( checkInputForInvalidColors(givenCombination) && checkInputLength(givenCombination) ) {
					correctInput = true;
				} else {
					System.out.println("Sorry, but you can only use the following colors:");
					System.out.println("R (Red), G (Green), B (Blue), Y (Yellow)");
				}
			}
		}
		catch(IOException ioe) {
			System.out.println("Error receiving the input");
			System.exit(1);
		}
		
		return this.givenColorCombination;
	}
	
	public final boolean checkInputForInvalidColors(final String colorCombination) {
		boolean valid = true;
		
		char[] availableColors = {'R', 'G', 'B', 'Y'};
		
		for(int i = 0; i < colorCombination.length(); i++) {
			if ( valid && !charInArray( colorCombination.charAt(i), availableColors ) ) {
				valid = false;
			}
		}
		
		return valid;
	}
	
	public final boolean charInArray( final char c, final char[] charArray ) {
		
		for(int i = 0; i < charArray.length; i++) {
			if( c == charArray[i] ) {
				return true;
			}
		}
		
		return false;
	}
	
	public final boolean checkInputLength(final String givenColorCombinationToCheck) {
		return (givenColorCombinationToCheck.length() == this.numberOfPins) ? true : false;
	}

	public final void generateNewCombination() {
		StringBuffer secretCombination = new StringBuffer();
		char[] availableColors = {'R', 'G', 'B', 'Y'};
		
		for(int i = 0; i < numberOfPins; i++) {
			int randomNumber = (int) Math.round(Math.random()*(availableColors.length-1));
			secretCombination.append(availableColors[randomNumber]);
		}
		
		correctCombination = new ColorCombination(secretCombination.toString());
		
		System.out.println("We have just entered our secret combination, try and guess!");
	}

	public final void checkColorCombination(final ColorCombination colorCombination) {
		throw new UnsupportedOperationException();
	}

	public final void createNewGuess(final String guessedCombination) {
		Guess attempt = new Guess(correctCombination.returnColorCombinationAsString(),
								  guessedCombination);
		attempts.add(attempt);
		
	}
	
	public final void setRightColorCombination(final ColorCombination newColorCombination) {
		correctCombination = newColorCombination;
	}
		
	public final int getNumberOfAttempts() {
		return this.numberOfAttempts;
	}
	
	public final int getAttemptsMade() {
		return this.attemptsMade;
	}

	public final void increaseNumberOfAttemptsMade(){
		this.attemptsMade++;
	}

	public final ArrayList<Guess> getAttempts() {
		return attempts;
	}

	public final void setAttempts(final ArrayList<Guess> attemptsToSet) {
		this.attempts = attemptsToSet;
	}
	
	public final ColorCombination getCorrectCombination() {
		return correctCombination;
	}

	public final void setCorrectCombination(final ColorCombination correctCombinationattemptsToSet) {
		this.correctCombination = correctCombinationattemptsToSet;
	}

	public final String getGivenColorCombination() {
		return givenColorCombination;
	}

	public final void setGivenColorCombination(final String givenColorCombinationToSet) {
		this.givenColorCombination = givenColorCombinationToSet;
	}
}
