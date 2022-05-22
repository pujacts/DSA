package com.recursion;

public class LinearSearch {

	public static void main(String[] args) {

		int[] arr = { 2, 8, 0, 1, 45, 13 };
		System.out.println(search(arr, 1, 0));

	}

	private static int search(int[] arr, int target, int idx) {
		if(idx == arr.length) {
			return -1;
		}
		if (arr[idx] == target) {
			return idx;
		} else {
			return search(arr, target, idx + 1);
		}
	}

}
