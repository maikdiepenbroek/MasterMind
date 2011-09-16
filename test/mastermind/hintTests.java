package mastermind;
import mastermind.Hint;

import org.junit.Test;
import static org.junit.Assert.*;

public class hintTests {

	@Test
	public void testOnlyOneCorrectPin() throws IllegalArgumentException
	{
		String guess 	= "RBBB";
		String correct 	= "YBYY";
		
		Hint hint = new Hint(correct, guess);
		hint.calculateHint();
		
		assertEquals("O---", hint.getHint());
	}
	
	@Test
	public void testOnlyOneCorrectPinAndOneMisplaced() throws IllegalArgumentException
	{
		String guess 	= "RBBB";
		String correct 	= "YBYR";
		
		Hint hint = new Hint(correct, guess);
		hint.calculateHint();
		
		assertEquals("OX--", hint.getHint());
	}
	
	@Test
	public void testAllPinsCorrect() throws IllegalArgumentException
	{
		String guess 	= "RGYB";
		String correct 	= "RGYB";
		
		Hint hint = new Hint(correct, guess);
		hint.calculateHint();
		
		assertEquals("OOOO", hint.getHint());
	}
	
	@Test
	public void testAllPinsMisplaced() throws IllegalArgumentException
	{
		String guess 	= "RGYB";
		String correct 	= "BYGR";
		
		Hint hint = new Hint(correct, guess);
		hint.calculateHint();
		
		assertEquals("XXXX", hint.getHint());
	}
	
	@Test
	public void testAllPinsIncorrect() throws IllegalArgumentException
	{
		String guess 	= "RGYB";
		String correct 	= "WWWW";
		
		Hint hint = new Hint(correct, guess);
		hint.calculateHint();
		
		assertEquals("----", hint.getHint());
	}
}