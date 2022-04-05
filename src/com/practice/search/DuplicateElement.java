package com.practice.search;

import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateElement {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 3, 9, 1, 10 };

		System.out.println("Lets print duplicate elements");
		duplicate(arr);
		
		System.out.println("now print unique elemets");
		removeDuplicate(arr);

	}

	private static void removeDuplicate(int[] arr) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		print(map);

	}

	private static void duplicate(int[] arr) {

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}

		}
		printDuplicate(map);
	}

	private static void printDuplicate(LinkedHashMap<Integer, Integer> map) {

		for (Map.Entry<Integer, Integer> entryset : map.entrySet()) {

			if (entryset.getValue() >= 2) {
				System.out.println(entryset.getKey() + ",");
			}
		}
	}

	private static void print(LinkedHashMap<Integer, Integer> map) {

		for (Map.Entry<Integer, Integer> entryset : map.entrySet()) {

			if (entryset.getValue() == 1) {
				System.out.println(entryset.getKey() + ",");
			}
		}
	}
}
