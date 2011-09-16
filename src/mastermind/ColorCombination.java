package mastermind;

import java.util.ArrayList;
import mastermind.Pin;

public class ColorCombination {
	public ArrayList<Pin> combination;

	public ColorCombination(String guessedCombination) {
		for( int i = 0; i < guessedCombination.length(); i++ ) {
			combination.add(new Pin(guessedCombination.charAt(i)));
		}
	}
}