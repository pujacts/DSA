package com.sorting;

public class SortStringSelectionSort {

	public static void main(String args[]) {

		String[] str = { "GeeksforGeeks", "Practice.GeeksforGeeks", "GeeksQuiz" };

		int size = str.length;

		// Printing the array before sorting
		for (int i = 0; i < size; i++) {
			System.out.println(i + ": " + str[i]);
		}
		System.out.println();

		selectionSort(str, size);

		System.out.println("Sorted array is");

		// Printing the array after sorting
		for (int i = 0; i < size; i++) {
			System.out.println(i + ": " + str[i]);
		}
	}

	private static void selectionSort(String[] str, int size) {

		for (int i = 0; i < size - 1; i++) {
			int min_idx = i;

			for (int j = i + 1; j < size; j++) {
				if (str[j].compareTo(str[min_idx]) < 0) {
					min_idx = j;
				}
			}
			if (min_idx != i) {
				String temp = str[min_idx];
				str[min_idx] = str[i];
				str[i] = temp;
			}
		}

	}
}
