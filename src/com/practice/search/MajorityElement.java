package com.practice.search;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MajorityElement em = new MajorityElement();
		int[] arr = { 1, 5, 5, 13, 2, 31, 5 };
		int[] arr1 = { 1, 2, 2, 2, 2, 1, 1 };
		int maj = em.findByBrute(arr);
		print(maj);

		int maj1 = em.findByBrute(arr1);
		print(maj1);

		// usig sorting

		System.out.println("Majority element by sorting technique :");
		int majSort1 = em.findBySort(arr);
		print(majSort1);
		int majSort2 = em.findBySort(arr1);
		print(majSort2);

		System.out.println("Moore's Voting Algorithm");
		int majMoore1 = em.findByMoore(arr);
		print(majSort1);
		int majMoore2 = em.findByMoore(arr1);
		print(majSort2);

	}

	private int findByMoore(int[] arr) {
		int size = arr.length;
		int maj = arr[0];
		int count = 1;
		int maxcount = 1;
		for (int i = 1; i < size; i++) {
			if (arr[i] == maj) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				maj = arr[i];
				count++;
			}
		}

		count = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] == maj) {
				count++;
			}
		}
		if (count > size / 2) {
			return maj;
		}
		return Integer.MIN_VALUE;

	}

	private int findBySort(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		int size = arr.length;
		int majIndex = arr[size / 2];

		for (int i = 0; i < size; i++) {
			if (arr[i] == majIndex) {
				count++;
			}
		}

		if (count > size / 2) {
			return majIndex;
		}
		return Integer.MIN_VALUE;
	}

	private static void print(int maj) {
		if (maj == Integer.MIN_VALUE) {
			System.out.println("no Majority element");
		} else {
			System.out.println("majority element is:" + maj);
		}

	}

	private int findByBrute(int[] arr) {

		int size = arr.length;
		int majElement = arr[0];
		int maxCount = 1;
		int count = 1;

		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}

			if (count >= maxCount) {
				maxCount = count;
				majElement = arr[i];
				count = 1;
			}
		}

		if (maxCount > size / 2) {
			return majElement;
		}
		return Integer.MIN_VALUE;
	}

}
