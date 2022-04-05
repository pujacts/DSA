package com.sorting;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 9, 1, 8, 2, 7, 33, 6, 4, 5 };
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr) {
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int current = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > current; j = j-gap) {
					
					arr[j]= arr[j-gap];
				}
				
				arr[j] = current;
			}
		}

	}
}
