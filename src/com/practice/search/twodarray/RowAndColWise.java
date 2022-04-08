package com.practice.search.twodarray;

import java.util.Arrays;

public class RowAndColWise {

	public static void main(String[] args) {

		int[][] matrix = { { 12, 14, 16, 17 }, { 13, 15, 19, 20 }, { 23, 25, 26, 27 } };
		int key = 89;
		int[] index = search(matrix, key);

		System.out.println(Arrays.toString(index));

	}

	private static int[] search(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return new int[] { -1, -1 };
		}
		int row = 0;
		int col = matrix[0].length - 1;

		return binarySearch(matrix, row, col, target);
	}

	private static int[] binarySearch(int[][] matrix, int row, int col, int target) {

		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			}

			if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return new int[] { -1, -1 };
	}

}
