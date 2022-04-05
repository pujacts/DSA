package com.practice.search;

public class RainTapWater {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int size = arr.length;

		System.out.println(maxWater(arr, size));
		System.out.println(maxWater1(arr, size));
		System.out.println(maxwater2(arr, size));

	}

	private static int maxwater2(int[] arr, int size) {

		int res = 0;
		int maxleft = 0;
		int maxright = 0;
		int left = 0;
		int right = size - 1;

		while (left <= right) {
			if (arr[left] <= arr[right]) {
				if (arr[left] > maxleft) {
					maxleft = arr[left];
				} else {
					res += maxleft - arr[left];
				}
				left++;
			} else {
				if (arr[right] >= maxright) {
					maxright = arr[right];
				} else {
					res += maxright - arr[right];
				}
				right--;
			}
		}
		return res;
	}

	private static int maxWater1(int[] arr, int size) {

		int[] left = new int[size];
		int[] right = new int[size];
		left[0] = arr[0];
		right[size - 1] = arr[size - 1];
		int water = 0;
		for (int i = 1; i < size; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		for (int i = size - 2; i > 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		for (int i = 0; i < size; i++) {

			water += Math.min(left[i], right[i]) - arr[i];
		}
		return water;
	}

	private static int maxWater(int[] arr, int size) {

		int res = 0;

		for (int i = 1; i < size - 1; i++) {

			int leftMax = arr[i];
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, arr[j]);
			}

			int rightMax = arr[i];
			for (int j = i + 1; j < size; j++) {
				rightMax = Math.max(rightMax, arr[j]);
			}

			res = res + Math.min(leftMax, rightMax) - arr[i];
		}
		return res;
	}

}
