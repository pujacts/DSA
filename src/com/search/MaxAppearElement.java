package com.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxAppearElement {

	public static void main(String[] args) {
		MaxAppearElement ap = new MaxAppearElement();
		int[] arr = { 1, 30, 5, 13, 9, 31, 5, 5, 1, 1, 1, 1 };

		ap.findMaxAppearElementBrute(arr);
		ap.findMaxAppearElementSorting(arr);
		ap.findMaxAppearElementHash(arr);

	}

	private void findMaxAppearElementHash(int[] arr) {
		int max = arr[0];
		int maxcount = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entryset : map.entrySet()) {
				if(entryset.getValue() > maxcount) {
					maxcount = entryset.getValue();
					max = entryset.getKey();
				}
		}
		
		System.out.println("maximum number: " + max + " and count is:" + maxcount);

	}

	private void findMaxAppearElementSorting(int[] arr) {
		int maxCount = 1;
		int count = 1;
		int size = arr.length;
		Arrays.sort(arr);
		int max = arr[0];
		int curr = arr[0];

		for (int i = 1; i < size; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				count = 1;
				curr = arr[i];
			}

			if (count > maxCount) {
				maxCount = count;
				max = curr;
			}
		}
		System.out.println("maximum number: " + max + " and count is:" + maxCount);

	}

	private void findMaxAppearElementBrute(int[] arr) {

		int maxCount = 1;

		int size = arr.length;
		int max = arr[0];
		for (int i = 0; i < size - 1; i++) {
			int count = 1;
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				max = arr[i];
			}
		}

		System.out.println("maximum number: " + max + " and count is:" + maxCount);

	}

}
