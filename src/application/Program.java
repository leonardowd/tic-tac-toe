package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		char turn;
		int position;
		char p1 = 'X';
		char p2 = 'O';
		int p1Points = 0;
		int p2Points = 0;
		Boolean isGameOver = false;
		
		//gameBoard' Design
		char[][] gameBoard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
		};
			

		//Game
			System.out.println("==================");
			System.out.println("Player 1: 'X'");
			System.out.println("Player 2: 'O'");
			System.out.println("==================");
			System.out.print("Select who will play first: ");
			turn = sc.next().charAt(0);
			printGameBoard(gameBoard);
			System.out.println();
			//TODO fix the bug that, if there's an invalid position, the game continue with the other player
			while(!isGameOver) {
				System.out.println("Player " + turn);
				System.out.println("select a position: (1-9)");
				position = sc.nextInt();
				position(position, gameBoard, turn);
				printGameBoard(gameBoard);
				isGameOver = isGameOver(turn, gameBoard);
				if (isGameOver) {
					System.out.println("Player: '" + turn + "' won this round!");
					if (turn == 'X') {
						p1Points += 1;
					} else {
						p2Points += 1;
					}
					System.out.println("==================");
					System.out.println("Player 1 score: " + p1Points);
					System.out.println("Player 2 score: " + p2Points);
					System.out.println("==================");
					//TODO make a option to continue playing without erase the score
				}
				turn = changeTurn(turn);
				System.out.println("==========");
			}
			
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

	public static void position(int pos, char[][] gb, char turn) {
		switch(pos) {
		//TODO finish this méthod after fix the bug mentioned below
			case 1:
				if (gb[0][0] == 'X' || gb[0][0] == 'O') {
					System.out.println("Position not available");
				} else {
					gb[0][0] = turn;				
				}
			break;
			case 2:
				gb[0][2] = turn;
			break;
			case 3:
				gb[0][4] = turn;
			break;
			case 4:
				gb[2][0] = turn;
			break;
			case 5:
				gb[2][2] = turn;
			break;
			case 6:
				gb[2][4] = turn;
			break;
			case 7:
				gb[4][0] = turn;
			break;
			case 8:
				gb[4][2] = turn;
			break;
			case 9:
				gb[4][4] = turn;
			break;
		}
	}
}
