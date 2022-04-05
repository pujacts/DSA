package com.sorting.practice;

public class ZeroAndOnes {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 1, 1, 1, 0, 0, 0, 0, 0 }; 
		sort(arr);
		System.out.println("Array after sorting");
		for (int a : arr) {
			System.out.print(a + ",");
		}
	}

	private static void sort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int count = 0;
		while (left < right) {

			while (arr[left] == 0) {
				left++;
			}
			while (arr[right] == 1) {
				right--;
			}
			if(left<right) {
			swap(arr, left, right);
			count++;
			}
		}
		
		System.out.println("count is : " + count);
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;

	}

}
