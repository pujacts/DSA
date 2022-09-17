package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

    //using memoization
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here

        if(N==0) return false;
        HashMap<Integer, Boolean> lookup = new HashMap<>();

        return subsetSum(N-1, arr, sum, lookup);

    }

    static boolean subsetSum(int n, int[] arr, int sum, Map<Integer, Boolean> lookup){
        if(sum==0){
            return true;
        }

        if(n<0 || sum<0) return false;

        int key = sum;

        if(!lookup.containsKey(key))
        {
            boolean include = subsetSum(n-1, arr, sum-arr[n], lookup);
            boolean exclude = subsetSum(n-1, arr, sum, lookup);
            lookup.put(key, include|| exclude);
        }


        return lookup.get(key);

    }
}
