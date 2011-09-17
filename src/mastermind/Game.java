package mastermind;

import mastermind.Board;

public class Game {
	private static Game game;
	private Board board;
	private boolean gameInProgress = true;
	
	public static void main( final String[] args ) {
		game = new Game();
	}
	
	public Game() {
		setUpBoard();
		gameLoop();
	}

	public void setUpBoard() {
		board = new Board(4,8);
	}

	public void endGame() {
		gameInProgress = false;
	}

	public void askStartNewGame() {
		throw new UnsupportedOperationException();
	}

	public void showGameEnded() {
		System.out.println("Game ended");
	}
	
	
	private void gameLoop() {
		board.generateNewCombination();

		while(gameInProgress && board.getAttemptsMade() < board.getNumberOfAttempts()) {
			board.createNewGuess(board.askForNewCombination());
			Guess currentAttempt = board.getAttempts().get(board.getAttemptsMade());
			
			System.out.println(currentAttempt.hint.returnHintAsString());
			
			if(currentAttempt.hint.returnHintAsString().equals("OOOO")) {
				System.out.println("Correct");
				endGame();
			}			
			board.increaseNumberOfAttemptsMade();
		}
		showGameEnded();
		
	}
}

