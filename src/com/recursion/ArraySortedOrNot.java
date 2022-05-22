package com.recursion;

public class ArraySortedOrNot {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 0, 4, 5 };
		
		System.out.println(sorted(arr , 0));
	}

	private static boolean sorted(int[] arr, int idx) {
		
		if(idx == arr.length-1) {
			return true;
		}
		return arr[idx]< arr[idx+1] && sorted(arr, idx+1);
	}

}
