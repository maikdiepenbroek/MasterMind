package mastermind;

public class Hint {
	
	private StringBuffer hint = new StringBuffer();
	private StringBuffer colorCombination = new StringBuffer();
	private StringBuffer correctCombination = new StringBuffer();
	
	public Hint(String correctCombination, String colorCombination) {
		this.colorCombination.append( colorCombination );
		this.correctCombination.append( correctCombination );
	}

	public void calculateHint() {
		checkForCorrectlyPlacedPins();
		checkForMisplacedPins();
		checkForUnknownPins();
	}
	
	public String returnHintAsString() {
		return hint.toString();
	}
	
	private void checkForCorrectlyPlacedPins() {
		for( int i = 0; i < colorCombination.length(); i++ ) {
			if ( correctCombination.charAt(i) == colorCombination.charAt(i) ) {
				hint.append('O');
				colorCombination.replace(i, i+1, ".");
				correctCombination.replace(i, i+1, "*");
			}
		}
	}
	
	private void checkForMisplacedPins() {
		for( int i = 0; i < colorCombination.length(); i++ ) {
			for( int y = 0; y < colorCombination.length(); y++ ) {
				if ( correctCombination.charAt(i) == colorCombination.charAt(y) ) {
					hint.append('X');
					colorCombination.replace(y, y+1, ".");
					correctCombination.replace(i, i+1, "*");
				}
			}
		}
	}
	
	private void checkForUnknownPins() {
		for( int i = 0; i < colorCombination.length(); i++ ) {
			if ( colorCombination.charAt(i) != '.' ) {
				hint.append('-');
			}
		}
	}
}