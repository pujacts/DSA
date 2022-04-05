package com.sorting.practice;

import java.util.HashMap;

public class SortByOrder {

	public static void main(String[] args) {
		int[] arr1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int[] arr2 = { 2, 1, 8, 3 };

		sortByOrder(arr1, arr1.length, arr2, arr2.length);

	}

	private static void sortByOrder(int[] arr1, int length, int[] arr2, int length2) {

		HashMap<Integer, Integer> ht = new HashMap<>();

		for (int a : arr1) {
			if (ht.containsKey(a)) {
				ht.put(a, ht.get(a) + 1);
			} else {
				ht.put(a, 1);
			}
		}

		for (int a : arr2) {
			if (ht.containsKey(a)) {
				int value = ht.get(a);
				for (int i = 1; i <= value; i++) {
					System.out.println(a + ",");
				}
				ht.remove(a);
			}
		}

		for (int a : arr1) {
			if (ht.containsKey(a)) {
				int value = ht.get(a);
				for (int i = 1; i <= value; i++) {
					System.out.println(a + ",");
				}
			}
			ht.remove(a);
		}
	}

}
