package mastermind;

public class Pin {
	private char color;

	public Pin(final char newColor) {
		this.color = newColor;
	}
	
	public final char getColor() {
		return this.color;
	}
}
