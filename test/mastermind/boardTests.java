package mastermind;
import org.junit.Test;
import static org.junit.Assert.*;

import mastermind.Board;

public class boardTests {

	@Test
	public void testForCorrectColorInput() {
		Board board = new Board(4,8);
		String colorCombination = "RGYY";
		
		assertTrue(board.checkInputForInvalidColors(colorCombination));
		
	}
	
}
