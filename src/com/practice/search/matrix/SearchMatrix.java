package com.practice.search.matrix;

public class SearchMatrix {

	public static void main(String[] args) {

		int matrix[][] = { { 0, 6, 8, 9, 11 }, 
				{ 20, 22, 28, 29, 31 }, 
				{ 36, 38, 50, 61, 63 }, 
				{ 64, 66, 100, 122, 128 } };

		int target = 122;

		System.out.println(searchBruteForce(matrix, target));
		System.out.println(search(matrix, target));
		System.out.println(searchBinarySarch(matrix, target));
	}

	private static boolean searchBinarySarch(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		int low = 0;
		int high = (row*col)-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(matrix[mid/col][mid%col] == target) {
				return true;
			}
			if(matrix[mid/col][mid%col] < target) {
				low= mid+1;
			} else {
				high = mid-1;
			}
		}
		
		return false;
	}

	private static boolean search(int[][] matrix, int target) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0;
		int j = col-1;
		while(i<row && j>=0) {
			if(matrix[i][j] == target) {
				return true;
			}
			if(matrix[i][j]< target) {
				i++;
			} else {
				j--;
			}
		}
		
		return false;
	}

	private static boolean searchBruteForce(int[][] matrix, int target) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i = 0 ; i<row; i++) {
			for(int j = 0 ; j<col ; j++) {
				if(matrix[i][j]==target) {
					return true;
				}
			}
		}
		
		return false;

	}

}
