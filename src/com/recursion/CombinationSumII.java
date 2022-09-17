package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2( candidates, target);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {


        List<List<Integer>> ans = new ArrayList();
        if(candidates.length==0) return ans;
        Arrays.sort(candidates);
        findcombinationSum(candidates, target, 0, new ArrayList<>(), ans);
        return ans;


    }

    public static void findcombinationSum(int[] arr, int target, int idx ,
                                   List<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(i > idx && arr[i]==arr[i-1]) continue;
            if(arr[i] > target) break;
            curr.add(arr[i]);
            findcombinationSum(arr, target - arr[i], i+1, curr, result);
            curr.remove(curr.size() - 1);
        }

    }
}
