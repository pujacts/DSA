package com.practice.cyclic.sort;

public class MissingPositive {

	public static void main(String[] args) {

		MissingPositive ms = new MissingPositive();
		int[] nums = { 1 };
		int n = ms.firstMissingPositive(nums);
		System.out.println(n);

	}

	private int firstMissingPositive(int[] nums) {

		int n = nums.length;
		int i = 0;
		while (i < n) {
			int current = nums[i] - 1;
			if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[current]) {
				swap(nums, i, current);
			} else {
				i++;
			}
		}
		for (int j = 0; j < n; j++) {
			if (nums[j] != j+1) {
				return j+1;
			}
		}
		return n+1;

	}

	private void swap(int[] nums, int i, int current) {

		int temp = nums[i];
		nums[i] = nums[current];
		nums[current] = temp;

	}
}
