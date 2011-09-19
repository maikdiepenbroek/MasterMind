package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Board {
	private int numberOfPins, numberOfAttempts, attemptsMade = 0;
			
	public ArrayList<Guess> attempts = new ArrayList<Guess>();
	public ColorCombination correctCombination;
	public String givenColorCombination = null;
	
	public Board(int numberOfPins, int numberOfAttempts) {
		this.numberOfPins 	  = numberOfPins;
		this.numberOfAttempts = numberOfAttempts;
		 
		System.out.println("Board has been set up.");
	}
	
	public String askForNewCombination() {
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
	
	public boolean checkInputForInvalidColors(String colorCombination) {
		boolean valid = true;
		
		char[] availableColors = {'R', 'G', 'B', 'Y'};
		
		for(int i = 0; i < colorCombination.length(); i++) {
			if ( valid == true && !charInArray( colorCombination.charAt(i), availableColors ) ) {
				valid = false;
			}
		}
		
		return valid;
	}
	
	public boolean charInArray( char c, char[] charArray ) {
		
		for(int i = 0; i < charArray.length; i++) {
			if( c == charArray[i] ) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkInputLength(String givenColorCombination) {
		return (givenColorCombination.length() == this.numberOfPins) ? true : false;
	}

	public void generateNewCombination() {
		StringBuffer secretCombination = new StringBuffer();
		char[] availableColors = {'R', 'G', 'B', 'Y'};
		
		for(int i = 0; i < numberOfPins; i++) {
			int randomNumber = (int) Math.round(Math.random()*(availableColors.length-1));
			secretCombination.append(availableColors[randomNumber]);
		}
		
		correctCombination = new ColorCombination(secretCombination.toString());
		
		System.out.println("We have just entered our secret combination, try and guess!");
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
