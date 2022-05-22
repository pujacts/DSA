package com.search.twodarray;

import java.util.Arrays;

public class SearchUsingBruteForce {

	public static void main(String[] args) {

		int[][] matrix = { { 12, 14, 16, 17 }, { 13, 15, 19, 20 }, { 23, 25, 26, 27 } };
		
		int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int key = 6;
		int[] index = search(matrix1, key);

		System.out.println(Arrays.toString(index));

	}

	private static int[] search(int[][] matrix, int key) {

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == key) {
					return new int[] { row, col };
				}
			}
		}
		return new int[] { -1, -1 };
	}

}
