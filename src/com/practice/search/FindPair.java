package com.practice.search;

import java.util.Arrays;
import java.util.HashSet;

public class FindPair {

	public static void main(String[] args) {

		FindPair pair = new FindPair();
		int[] arr = { 1, 5, 4, 3, 2, 7, 8, 9, 6 };

		System.out.println("pair brute force");
		pair.findPairBruteForce(arr, 8);

		System.out.println("pair using sort");
		pair.findPairUsingSort(arr, 8);

		System.out.println("pair using hashTable");
		pair.findPairUsingHash(arr, 8);
	}

	private void findPairUsingHash(int[] arr, int value) {

		HashSet<Integer> set = new HashSet<>();

//		for (int a : arr) {
//			set.add(a);
//		}
//
//		for (int a : arr) {
//			if (set.contains(value - a)) {
//				System.out.println(a + "," + (value - a));
//			}
//		}
		
		for(int i=0; i< arr.length ; i++) {
			if(set.contains(value-arr[i])) {
				System.out.println(arr[i] + "," + (value - arr[i]));
			}
			
			set.add(arr[i]);
		}

	}

	private void findPairUsingSort(int[] arr, int value) {
		int size = arr.length;
		int first = 0;
		int second = size - 1;

		int curr = 0;

		Arrays.sort(arr);
		while (first < second) {
			curr = arr[first] + arr[second];
			if (curr == value) {
				System.out.println(arr[first] + "," + arr[second]);
			}

			if (curr < value) {
				first++;
			} else {
				second--;
			}
		}

	}

	private void findPairBruteForce(int[] arr, int value) {

		int size = arr.length;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (value == (arr[i] + arr[j])) {

					System.out.println(arr[i] + "," + arr[j]);

				}
			}
		}
		return;

	}

}
