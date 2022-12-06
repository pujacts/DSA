package com.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairInList {

	public static void main(String[] args) {


		int xor = 0;
		int arr[] = {1, 2, 3, 5, 5};
		for(int ar : arr) {
			xor ^= ar;
		}

		for(int i = 1; i <= 5; i++){
			xor ^= i;
		}
		System.out.println(xor);

		PairInList pair = new PairInList();
		List<Integer> list1 = Arrays.asList(1, 10, 5, 6);
		List<Integer> list2 = Arrays.asList(2, 4, 8, 0, 3);

		pair.findPairBruteForce(list1, list2, 8);
		System.out.println("------------------------------------");
		pair.findUsingBinarySearch(list1, list2, 8);
		System.out.println("------------------------------------");
		pair.findPairUsingSorting(list1, list2, 8);
	}

	private void findPairUsingSorting(List<Integer> list1, List<Integer> list2, int value) {

		Collections.sort(list1);
		Collections.sort(list2);
		int list2Size = list2.size()-1;
		int sum = list1.get(0) + list2.get(list2Size);
		
		for (int i = 0; i < list1.size() && list2Size>0;) {
			if (value == sum) {
				System.out.println(list1.get(i) + "," + list2.get(list2Size));
			}  
			
			if (sum < value) {
				i++;
				sum = list1.get(i) + list2.get(list2Size);
			} else {
				list2Size--;
				sum = list1.get(i) + list2.get(list2Size);
			}

		}

	}

	private void findUsingBinarySearch(List<Integer> list1, List<Integer> list2, int value) {

		Collections.sort(list2);
		int mid = list2.size() / 2;
		for (int l1 : list1) {
			int diff = value - l1;

			if (list2.get(mid) == diff) {
				System.out.println(l1 + "," + list2.get(mid));
			}
			if (diff < list2.get(mid)) {
				for (int i = 0; i <= mid; i++) {
					if (diff == list2.get(i)) {
						System.out.println(l1 + "," + list2.get(i));
					}
				}
			} else if (diff > list2.get(mid)) {
				for (int i = mid + 1; i < list2.size(); i++) {
					if (diff == list2.get(i)) {
						System.out.println(l1 + "," + list2.get(i));
					}
				}
			}
		}
	}

	private void findPairBruteForce(List<Integer> list1, List<Integer> list2, int value) {

		for (int l1 : list1) {
			for (int l2 : list2) {
				if ((l1 + l2) == value) {
					System.out.println(l1 + "," + l2);
				}
			}
		}
	}

}
