package com.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 4, 3, 7, 6 };
		BubbleSort b = new BubbleSort();
		b.sort(arr);
		System.out.println("increasing order");
		print(arr);

		b.sortDesc(arr);
		System.out.println("decresing order");
		print(arr);

		int[] arr1 = { 1, 2, 3, 4, 5, 7, 6 };
		b.modifiedBubbleSort(arr1);
		System.out.println("modified bubble sort");
		print(arr1);
	}

	private void modifiedBubbleSort(int[] arr) {
		int size = arr.length - 1, swap = 1;
		int count = 0;

		for (int i = 0; i < size && swap == 1; i++) {
			count = count+i;
			for (int j = 0; j < size - i; j++) {
				swap = 0;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = 1;

				}
			}
		}
		System.out.println("no of swapping : "+ count);
	}

	private static void print(int[] arr) {

		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	private void sortDesc(int[] arr) {
		int size = arr.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	private void sort(int[] arr) {
		int size = arr.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
