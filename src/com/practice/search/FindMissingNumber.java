package com.practice.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//find missing numbers from n natural number
public class FindMissingNumber {

	public static void main(String[] args) {

		int[] first = { 1, 5, 4, 3, 2, 7, 8, 9, 11, 6 };

		System.out.println("missing number is :" + findMissingNo(first));
		System.out.println("missing number is using count :" + findMissingUsingCount(first));
		System.out.println("missing number is using hashtable :" + findMissingUsinghashtable(first));
		System.out.println("missing number is using XOR :" + findMissingUsingXOR(first));
	}

	private static int findMissingUsingXOR(int[] first) {
		int max = Arrays.stream(first).max().getAsInt();
		int xorSum = 0;
		for(int i=1; i< max; i++) {
			System.out.println("value of array is :" + first[i-1] + " value of i is :" + i + " value of xor is :" + xorSum);
			xorSum ^= i^ first[i-1];
		}
		xorSum ^= max;
		System.out.println( "final value of xor is :" + xorSum);
		return xorSum;
	}
	private static int findMissingUsinghashtable(int[] first) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : first) {

			map.put(a, 1);
		}

			for (int i = 1; i <= first.length; i++) {
				if (!map.containsKey(i)) {
					return i;
				}
			}
		return Integer.MAX_VALUE;
	}

	private static int findMissingUsingCount(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int[] count = new int[max];
		Arrays.fill(count, 0);

		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - 1]++;
		}

		for (int i = 1; i <= arr.length; i++) {
			if (count[i - 1] == 0) {
				return i;
			}
		}
		return Integer.MAX_VALUE;
	}

	private static int findMissingNo(int[] arr) {

		int size = arr.length;
		int i, j;
		int found = 0;
		for (i = 1; i <= size; i++) {
			found = 0;
			for (j = 0; j < size; j++) {
				if (arr[j] == i) {
					found = 1;
					break;
				}
			}

			if (found == 0) {
				return i;
			}
		}
		return Integer.MAX_VALUE;
	}

}
