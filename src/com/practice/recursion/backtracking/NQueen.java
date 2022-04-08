package com.practice.recursion.backtracking;

public class NQueen {

	public static void main(String[] args) {
		int n = 4;
		boolean[][] board = new boolean[n][n];

		int count = queen(board, 0);

		System.out.println(count);
	}

	private static int queen(boolean[][] board, int row) {

		if (row == board.length) {
			display(board);
			return 1;
		}

		int count = 0;
		// placing the queen and checking every row and coloum
		for (int i = 0; i < board.length; i++) {

			if (isSafe(board, row, i)) {
				board[row][i] = true;
				count = count + queen(board, row + 1);
			}
			board[row][i] = false;
		}
		return count;

	}

	private static boolean isSafe(boolean[][] board, int row, int col) {

		// check same column
		for (int i = 0; i < row; i++) {
			if (board[i][col]) {
				return false;
			}
		}
		// check left diagonal
		int maxLeft = Math.min(row, col);
		for (int i = 1; i <= maxLeft; i++) {
			if (board[row - i][col - i]) {
				return false;
			}
		}

		// check right diagonal
		int maxRight = Math.min(row, board.length - col - 1);
		for (int i = 1; i <= maxRight; i++) {
			if (board[row - i][col + i]) {
				return false;
			}
		}
		return true;
	}

	private static void display(boolean[][] board) {

		for (boolean[] row : board) {
			for (boolean element : row) {
				if (element) {
					System.out.print("Q ");
				} else
					System.out.print("X ");
			}
			System.out.println();
		}

		System.out.println();
	}

}
