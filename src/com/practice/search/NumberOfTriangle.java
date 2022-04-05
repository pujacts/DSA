package com.practice.search;

public class NumberOfTriangle {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		traingle(arr);
		// using the trick if arr[i]+arr[j]> arr[k] than arr[i] + arr[j+1] will also be
		// greater than l
		traingle2(arr);

	}

	private static void traingle2(int[] arr) {
		int size = arr.length;
		int count = 0;
		int count1 = 0;

		for (int i = 0; i < size - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < size - 1; j++) {
				while (k < size && arr[i] + arr[j] > arr[k]) {
					System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
					k++;
					count++;
				}

				count1 = count1 + k - j - 1;
			}
		}
		System.out.println("count is: " + count);
		System.out.println("count is: " + count1);

	}

	private static void traingle(int[] arr) {

		int size = arr.length;
		int count = 0;
		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (arr[i] + arr[j] > arr[k]) {
						System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
						count++;
					}
				}
			}
		}

		System.out.println("count is: " + count);

	}

}
