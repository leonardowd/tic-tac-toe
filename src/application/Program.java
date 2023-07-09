package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		char turn;
		int position;
		int p1Points = 0;
		int p2Points = 0;
		boolean isAvailable = true;
		boolean isGameOver = false;
		boolean endGame = false;
		
		//gameBoard' Design
		char[][] gameBoard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
		};
			
		//GAME STARTS
		do {
			System.out.println("==================");
			System.out.println("Player 1: 'X'");
			System.out.println("Player 2: 'O'");
			System.out.println("==================");
			System.out.print("Select who will play first: (X/O) ");
			turn = sc.next().charAt(0);
			turn = Character.toUpperCase(turn);

			addLines();
			
			printGameBoard(gameBoard);
			System.out.println();
			
			//TODO fix the bug that user can select other player until X or O
			while(!isGameOver) {
				System.out.println("Player " + turn);
				System.out.println("select a position: (1-9)");
				position = sc.nextInt();
				isAvailable = position(position, gameBoard, turn, isAvailable);
				while (!isAvailable) {
					System.out.print("Type a new position: (1-9) ");
					position = sc.nextInt();
					isAvailable = position(position, gameBoard, turn, isAvailable);
				}
				printGameBoard(gameBoard);
				System.out.println(); //just to add a breakLine
				isGameOver = isGameOver(turn, gameBoard);
				if (isGameOver) {
					System.out.println("Player: '" + turn + "' won this round!");
					System.out.println();
					if (turn == 'X') {
						p1Points += 1;
					} else {
						p2Points += 1;
					}
					System.out.println("==================");
					System.out.println("Player 1 score: " + p1Points);
					System.out.println("Player 2 score: " + p2Points);
					System.out.println("==================");
				}
				
				if (isDraw(gameBoard)) {
					System.out.println("Press anykey to play again");
					String anyKey = sc.next();
					clearBoard(gameBoard);
					printGameBoard(gameBoard);
				}
				
				turn = changeTurn(turn);
			}
			
			//check if players want to end the game
			System.out.println("Do you want to end the game? (Y/N) ");
			char eGame = sc.next().charAt(0);
			eGame = Character.toUpperCase(eGame);
			
			if (eGame == 'Y') {
				System.out.println("Player 1 (" + p1Points + ")"+ " VS (" + p2Points + ") Player 2.");
				System.out.println("------------------------------------");
				if (p1Points > p2Points) {
					System.out.println("Player 1 won the game!!");
				} else if (p1Points == p2Points) {
					System.out.println("It's a DRAW!!");
				} else {
					System.out.println("Player 2 won the game!!");
				}
				
				endGame = true;
			} else {
				isGameOver = false;
				clearBoard(gameBoard);
			}
			
		} while (!endGame);
		//GAME ENDS
			
			sc.close();
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
	
	public static char changeTurn(char turn) {
		if (turn == 'X') {
			return 'O';
		} else {
			turn = 'X';
			return 'X';
		}
	}
	
	//Verify if game is over or not
	public static boolean isGameOver(char turn, char[][] gb) {
		if (gb[0][0] == turn && gb[0][2] == turn && gb[0][4] == turn
				|| gb[2][0] == turn && gb[2][2] == turn && gb[2][4] == turn
				|| gb[4][0] == turn && gb[4][2] == turn && gb[4][4] == turn
				|| gb[0][0] == turn && gb[2][0] == turn && gb[4][0] == turn
				|| gb[0][2] == turn && gb[2][2] == turn && gb[4][2] == turn
				|| gb[0][4] == turn && gb[2][4] == turn && gb[4][4] == turn
				|| gb[0][0] == turn && gb[2][2] == turn && gb[4][4] == turn
				|| gb[0][4] == turn && gb[2][2] == turn && gb[4][0] == turn) {
			return true;
		}
		return false;
	}	
	
	public static boolean isDraw(char [][] gb) {
				if (gb[0][0] != ' '  && gb[0][2] != ' ' && gb[0][4] != ' '
					&& gb[2][0] != ' ' && gb[2][2] != ' ' && gb[2][4] != ' '
					&& gb[4][0] != ' ' && gb[4][2] != ' ' && gb[4][4] != ' ') {
							
						System.out.println("IT'S A DRAW!!");
						return true;
					} 
						return false;
				} 

	//print the board's position depending on player's turn
	public static boolean position(int pos, char[][] gb, char turn, boolean isAvailable) {
		switch(pos) {
			case 1:
				if (gb[0][0] == 'X' || gb[0][0] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[0][0] = turn;	
					isAvailable = true;
				}
			break;
			case 2:
				if (gb[0][2] == 'X' || gb[0][2] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[0][2] = turn;	
					isAvailable = true;
				}
			break;
			case 3:
				if (gb[0][4] == 'X' || gb[0][4] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[0][4] = turn;	
					isAvailable = true;
				}
			break;
			case 4:
				if (gb[2][0] == 'X' || gb[2][0] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[2][0] = turn;	
					isAvailable = true;
				}
			break;
			case 5:
				if (gb[2][2] == 'X' || gb[2][2] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[2][2] = turn;	
					isAvailable = true;
				}
			break;
			case 6:
				if (gb[2][4] == 'X' || gb[2][4] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[2][4] = turn;	
					isAvailable = true;
				}
			break;
			case 7:
				if (gb[4][0] == 'X' || gb[4][0] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[4][0] = turn;	
					isAvailable = true;
				}
			break;
			case 8:
				if (gb[4][2] == 'X' || gb[4][2] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[4][2] = turn;	
					isAvailable = true;
				}
			break;
			case 9:
				if (gb[4][4] == 'X' || gb[4][4] == 'O') {
					System.out.println("Position not available");
					isAvailable = false;
				} else {
					gb[4][4] = turn;	
					isAvailable = true;
				}
			break;
		}
		if (!isAvailable) {
			return false;
		}
		return true;
	}
	
	public static void clearBoard(char[][] gb) {
		gb[0][0] = ' ';
		gb[0][2] = ' ';
		gb[0][4] = ' ';
		gb[2][0] = ' ';
		gb[2][2] = ' ';
		gb[2][4] = ' ';
		gb[4][0] = ' ';
		gb[4][2] = ' ';
		gb[4][4] = ' ';
	}
	
	//Method to add lines to better see the gameboard after a movement
	public static void addLines() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
}
