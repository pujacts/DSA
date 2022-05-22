package com.search;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		int[] arr = { 15, 5, 5, 0, 10, 5, 5, 0, 10, 1 };
		System.out.println(subarraySum(arr, 20));
		int[] arr1 = { 1, -1, 0 };
		System.out.println(subarraySum1(arr1, 0));
		System.out.println(subArray3(arr1, 0));

	}

	private static int subArray3(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

	private static int subarraySum1(int[] arr, int value) {
		int size = arr.length;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			sum = 0;

			for (int j = i; j < size; j++) {
				sum = sum + arr[j];
				if (sum == value) {
					count = count + 1;

				}
			}
		}

		return count;
	}

	private static int subarraySum(int[] nums, int k) {
		int first = 0;
		int second = 0;
		int sum = nums[first];
		int size = nums.length;
		int count = 0;

		while (first < size && second < size) {
			if (sum == k) {
				count = count + 1;
			}

			if (sum < k) {
				second = second + 1;
				if (second < size) {
					sum = sum + nums[second];
				}
			} else {
				sum = sum - nums[first];
				first = first + 1;
			}
		}
		return count;
	}

}
