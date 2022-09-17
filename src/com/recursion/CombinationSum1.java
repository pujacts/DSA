package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        if(candidates.length==0) return ans;

        findcombinationSum(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void findcombinationSum(int[] candidates, int target, int idx ,
                                   List<Integer> curr, List<List<Integer>> result){
        if(idx >= candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        if(candidates[idx] <= target){
            curr.add(candidates[idx]);
            findcombinationSum(candidates, target - candidates[idx], idx, curr, result);
            curr.remove(curr.size() - 1);
        }
        findcombinationSum(candidates, target, idx + 1, curr, result);
    }
}
