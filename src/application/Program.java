package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		char turn;
		int position;
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
			System.out.print("Select who will play first: ");
			turn = sc.next().charAt(0);
			printGameBoard(gameBoard);
			System.out.println();
			//TODO fix the bug that the actually player subscribe the older player
			while(!isGameOver) {
				System.out.println("Player " + turn);
				System.out.println("select a position: (1-9)");
				position = sc.nextInt();
				position(position, gameBoard, turn);
				printGameBoard(gameBoard);
				isGameOver = isGameOver(turn, gameBoard);
				if (isGameOver) {
					System.out.println("Player: '" + turn + "' won this round!");
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
		case 1:
			gb[0][0] = turn;
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
