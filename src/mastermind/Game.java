package mastermind;

public class Game {
	private static Game game;
	private Board board;
	private boolean gameInProgress = true;
	private final int NUMBEROFPINS = 4;
	private final int NUMBEROFGUESSES = 8;
	
	public static void main( final String[] args ) {
		game = new Game();
	}
	
	public Game() {
		showGameInfo();
		setUpBoard();
		gameLoop();
	}

	public final void setUpBoard() {
		board = new Board(NUMBEROFPINS,NUMBEROFGUESSES);
	}

	public final void endGame() {
		gameInProgress = false;
	}

	public final void askStartNewGame() {
		throw new UnsupportedOperationException();
	}
	
	private void gameLoop() {
		board.generateNewCombination();

		while(gameInProgress && board.getAttemptsMade() < board.getNumberOfAttempts()) {
			board.createNewGuess(board.askForNewCombination());
			Guess currentAttempt = board.getAttempts().get(board.getAttemptsMade());
			
			System.out.println(currentAttempt.getHint().returnHintAsString());
			
			if(currentAttempt.getHint().returnHintAsString().equals("OOOO")) {
				System.out.println("Correct");
				endGame();
			}			
			board.increaseNumberOfAttemptsMade();
		}
		showGameEnded();
		
	}
	
	public final void showGameEnded() {
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

