package com.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class longestSubsequence {

    public static void main(String[] args) {
        int[] arr = {2,6,1,9,4,5,3};

        System.out.println(findLongestConseqSubseq(arr));
        
    }

    private static int findLongestConseqSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for(int x : arr){
            set.add(x);
        }
        int longest = 0;
        for(int x : arr){
            int currsum = x;
            int count = 1;

            while(set.contains(currsum+1)){
                currsum++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}
