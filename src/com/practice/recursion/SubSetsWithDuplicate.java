package com.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsWithDuplicate {

	 public List<List<Integer>> subsetsWithDup(int[] nums) {
	    	List<List<Integer>> result = new ArrayList<>();
	        Arrays.sort(nums);
	        subsetsWithDup(result, new ArrayList<>(), nums, 0);
	        return new ArrayList<>(result);
	    }
	    
	    public void subsetsWithDup(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
	        result.add(new ArrayList<>(temp));
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i - 1])
	                continue;
	            temp.add(nums[i]);
	            subsetsWithDup(result, temp, nums, i + 1);
	            temp.remove(temp.size() - 1);
	        }
	    }
	    
	    public static void main(String[] args) {
	    	int nums[] = { 1, 1, 2, 2 };
	    	SubSetsWithDuplicate ss = new SubSetsWithDuplicate();
			ss.subsetsWithDup(nums).forEach(num -> System.out.println(num));
		}
	}
