package com.search;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedElement {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 3, 9, 1, 10 };

		System.out.println(findFirstRepeated(arr));

	}

	private static Integer findFirstRepeated(int[] arr) {

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int a : arr) {
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}

//			if(map.get(a) == 2) {
//				return getkey(map, a); 
//			}
		}
		return getkey(map);
	}

	private static Integer getkey(LinkedHashMap<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer> entryset : map.entrySet()) {
			if (entryset.getValue() == 2) {
				return entryset.getKey();
			}
		}
		return -1;
	}

}
