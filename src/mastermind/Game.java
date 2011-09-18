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
		showGameInfo();
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
	
	public void showGameEnded() {
		System.out.println("Game ended");
	}
	
	private void showGameInfo() {
		System.out.println(" ------------------------------------------");
		System.out.println("|               MasterMind by             |");
		System.out.println("|   Wouter Konecny and Maik Diepenbroek   |");
		System.out.println("|                                         |");
		System.out.println("|             18 September 2011           |");
		System.out.println(" ------------------------------------------");
	}
}

