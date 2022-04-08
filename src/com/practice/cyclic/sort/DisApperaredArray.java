package com.practice.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

class DisApperaredArray {

	public static void main(String[] args) {
		DisApperaredArray s = new DisApperaredArray();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> list = s.findDisappearedNumbers(nums);
		System.out.println(list);
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {

		int n = nums.length;
		int i = 0;
		while (i < n) {
			int current = nums[i] - 1;
			if (nums[i] != nums[current]) {
				swap(nums, i, current);
			} else { 
				i++;
			}
		}
		
		List<Integer> duplicate = new ArrayList<>();
		for(int j = 0; j< n; j++) {
			if(nums[j] != j+1) {
				duplicate.add(j+1);
			}
		}
		return duplicate;

	}

	private void swap(int[] nums, int i, int current) {

		int temp = nums[i];
		nums[i] = nums[current];
		nums[current] = temp;

	}
}