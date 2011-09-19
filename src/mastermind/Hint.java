package mastermind;

public class Hint {
	
	private StringBuffer hint = new StringBuffer();
	private StringBuffer colorCombination = new StringBuffer();
	private StringBuffer correctCombination = new StringBuffer();
	
	public Hint(final String theCorrectCombination, final String theColorCombination) {
		this.colorCombination.append( theColorCombination );
		this.correctCombination.append( theCorrectCombination );
	}

	public final void calculateHint() {
		checkForCorrectlyPlacedPins();
		checkForMisplacedPins();
		checkForUnknownPins();
	}
	
	public final String returnHintAsString() {
		return hint.toString();
	}
	
	private void checkForCorrectlyPlacedPins() {
		for( int i = 0; i < this.colorCombination.length(); i++ ) {
			if ( correctCombination.charAt(i) == this.colorCombination.charAt(i) ) {
				hint.append('O');
				this.colorCombination.replace(i, i+1, ".");
				this.correctCombination.replace(i, i+1, "*");
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
