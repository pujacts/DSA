package com.practice.search;

import java.util.Arrays;
import java.util.HashMap;

public class FrequencyCounts {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2,2, 1 };
		countUsingHash(arr);
		System.out.println("------------------------------");
		countusingLinear(arr);
		System.out.println("------------------------------");
		int[] arr1 = { 1, 2, 2, 2, 1 };
		countUsingCountSort(arr1);
	}

	private static void countusingLinear(int[] arr) {

		int index;
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] > 0) {
				index = arr[i] - 1;
				if (arr[index] > 0) {
					arr[i] = arr[index];
					arr[index] = -1;
				} else {
					arr[index] -= 1;
					arr[i] = 0;
				}
			}

		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + ":" + Math.abs(arr[i]));
		}

	}

	private static void countUsingCountSort(int[] arr) {
		int lower = 1;
		int size = arr.length;
		int[] count = new int[size];
		Arrays.fill(count, 0);
		for (int i = 0; i < size; i++) {
			count[arr[i] - lower]++;
		}

		for (int i = 0; i < size; i++) {
			System.out.println(i+1 + ":" + count[i]);
		}

	}

	private static void countUsingHash(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		for (int i = 1; i <= arr.length; i++) {
			System.out.println(i + ":" + map.getOrDefault(i, 0));
		}

	}

}
