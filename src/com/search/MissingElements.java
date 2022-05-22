package com.search;

import java.util.Arrays;
import java.util.HashSet;

public class MissingElements {

	public static void main(String[] args) {

		int[] arr = { 11, 14, 13, 21, 18, 19, 23, 24, 17 };

		System.out.println("missing elements using brute force");
		findMissingElements(arr);

		System.out.println("missing elements using sorting");
		findMissingElementsSorting(arr);

		System.out.println("missing elements using hashtable");
		findMissingElementshash(arr);
		
		System.out.println("missing elements using Xor");
		findMissingElementsXor(arr);

	}

	private static void findMissingElementsXor(int[] arr) {
		
		for(int i = 0; i< arr.length ; i++) {
			
		}
		
	}

	private static void findMissingElementshash(int[] arr) {

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		HashSet<Integer> set = new HashSet<>();
		for(int a : arr) {
			set.add(a);
		}
		
		
		for(int i = min ; i<=max ; i++) {
			if(set.contains(i) == false) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	private static void findMissingElementsSorting(int[] arr) {

		Arrays.sort(arr);
		int value = arr[0];
		int i = 0;
		while (i < arr.length) {
			if (value == arr[i]) {
				value++;
				i++;
			} else {
				System.out.print(value + " ");
				value++;
			}
		}
		System.out.println();

	}

	private static void findMissingElements(int[] arr) {

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int found = 0;

		for (int i = min; i <= max; i++) {
			int j = 0;
			while (j < arr.length) {
				found = 0;
				if (arr[j] == i) {
					found = 1;
					break;
				}
				j++;
			}

			if (found == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

}
