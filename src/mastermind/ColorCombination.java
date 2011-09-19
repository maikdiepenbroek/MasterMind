package mastermind;

import java.util.ArrayList;


public class ColorCombination {
	private ArrayList<Pin> combination = new ArrayList<Pin>();

	public ColorCombination(final String guessedCombination) {
		for( int i = 0; i < guessedCombination.length(); i++ ) {
			combination.add(new Pin(guessedCombination.charAt(i)));
		}
	}
	
	public final String returnColorCombinationAsString() {
		StringBuffer tempCombination = new StringBuffer();
		
		for( int i = 0; i < combination.size(); i++ ) {
			tempCombination.append(combination.get(i).getColor());
		}		
		return tempCombination.toString();
	}
}
