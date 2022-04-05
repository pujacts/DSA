package com.sorting;

import java.util.Arrays;

public class CountSort1 {

	public static void main(String[] args) {
		char[] arr = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's' };

		CountSort1 c = new CountSort1();
		c.sort(arr);
		System.out.println("Sorted character array is ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+",");
		System.out.println();
		System.out.println("------------------------------------------------------ ");
		int[] arr1 = { -5, -10, 0, -3, 8, 5, -1, 10 };
		c.countSort(arr1);
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ,");
	}

	private void sort(char[] arr) {

		int size = arr.length;
		int count[] = new int[256];
		char[] output = new char[size];
		Arrays.fill(count, 0);

		for (int i = 0; i < size; i++) { // to fill the count array
			count[arr[i]]++;
		}

		for (int i = 1; i < count.length; i++) { // to find the position of each character in the array
			count[i] += count[i - 1];
		}

		for (int i = size - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}

		for (int i = 0; i < size; i++) {
			arr[i] = output[i];
		}
	}

	private void countSort(int[] arr) {
		//{ -5, -10, 0, -3, 8, 5, -1, 10 };
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int count[] = new int[range];
		int output[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

}
