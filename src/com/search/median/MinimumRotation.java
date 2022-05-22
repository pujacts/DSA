package com.search.median;

public class MinimumRotation {

	public static void main(String[] args) {

		MinimumRotation mr = new MinimumRotation();
		int[] nums = { 34, 56, 77, 80, 5, 6, 6, 8, 10, 20, 30, 34 };
		System.out.println(mr.findMin(nums));

	}

	public int findMin(int[] nums) {

		int low = 0;
		int high = nums.length - 1;

		if (nums.length == 1) {
			return nums[0];
		}
		if (nums[high] > nums[low]) {
			return nums[0];
		}
		if (nums.length == 2 && nums[1] > nums[0]) {
			return nums[0];
		}
		if (nums.length == 2 && nums[1] < nums[0]) {
			return nums[1];
		}

		while (high > low) {
			int mid = (low + high) / 2;

			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid - 1] > nums[mid]) {
				return nums[mid];
			}
			if (nums[mid] > nums[0]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

}
