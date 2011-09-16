package mastermind;

import mastermind.Board;

public class Game {
	private static Game game;
	private Board board;
	
	public static void main( final String[] args ) {
		game = new Game();
	}
	
	public Game() {
		setUpBoard();
	}

	public void setUpBoard() {
		board = new Board(4,8);
	}

	public void endGame() {
		throw new UnsupportedOperationException();
	}

	public void askStartNewGame() {
		throw new UnsupportedOperationException();
	}

	public void showGameEnded() {
		throw new UnsupportedOperationException();
	}

	public void enterGuessOnBoard(String guess) {
		throw new UnsupportedOperationException();
	}
}