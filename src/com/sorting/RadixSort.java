package com.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 432, 8, 530, 90, 88, 231, 11, 45, 677, 199 };
		sort(arr);
		for (int a : arr) {
			System.out.println(a);
		}
	}

	private static void sort(int[] arr) {
		int length = arr.length;
		int max = getMax(arr, length);
		//counting sort for every digit
		//the dividend passed is to calculate the current working digit
		for (int dividend = 1; max / dividend > 0; dividend *= 10) {
			countSort(arr,length,dividend);
		}

	}

	private static void countSort(int[] arr, int length, int dividend) {
		int temp[] = arr.clone();
		int[] count = new int[10];
		Arrays.fill(count, 0);
		//store count of occurances in count array
		//(number/divided)%10 is to find the current working digit
		for (int i = 0; i < length; i++) {
			count[(temp[i] / dividend) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = length - 1; i >= 0; i--) {
			arr[count[(temp[i]/dividend)%10]-1] = temp[i];
			count[(temp[i]/dividend)%10]--;
		}
		
	}

	private static int getMax(int[] arr, int length) {
		int max = arr[0];
		for (int i = 1; i < length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}
