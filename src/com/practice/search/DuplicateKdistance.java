package com.practice.search;

import java.util.HashMap;

public class DuplicateKdistance {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 1, 4, 5 };

		System.out.println(find(arr, 3));
		System.out.println(find(arr, 2));
	}

	private static boolean find(int[] arr, int range) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i <= range; i++) {

			if (hm.containsKey(arr[i])) {

				System.out.println(hm.get(arr[i]) + "," + i);
				return true;
			} else {
				hm.put(arr[i], i);
			}
		}
		return false;
	}

}
