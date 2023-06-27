package application;

public class Program {

	public static void main(String[] args) {

		final int ROWS = 3;
		final int COLS = 3;
		int position;
		
		char[][] gameBoard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
		};
			
			printGameBoard(gameBoard);
			
			for (int i = 1; i <= ROWS; i++) {
				for (int j = 1; j <= COLS; j++) {
					gameBoard[i][j] = 'X';
				}
			}
			
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}

}
