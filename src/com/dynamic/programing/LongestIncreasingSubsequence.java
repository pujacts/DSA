package com.dynamic.programing;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

      //  int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int[] arr = { 5, 8, 3, 7, 9, 1 };
        System.out.println(longestSubsequence(arr.length, arr));

    }

    static int longestSubsequence(int size, int a[])
    {
        if(size==1) return 1;

        return lcs(size, a, 0, Integer.MIN_VALUE);

    }
    static int lcs(int n, int a[], int i , int max){
        if(i==n) return 0;

        int excl = lcs(n, a, i+1, max);
        int incl = 0;

        if(a[i]> max){
            incl = 1+ lcs(n, a , i+1, a[i]);
        }

        return Math.max(excl, incl);
    }

    static int longestSubsequence1(int size, int a[])
    {
        int[][] dp = new int[size+1][size+1];

        for(int i=1;i<=size-1; i++){
            for(int previous_idx=0; previous_idx<i; previous_idx++){

                int len = 0 + dp[i+1][previous_idx];
                if(a[i]> a[previous_idx]){
                    len = Math.max(len , 1+dp[i+1][i]);
                }
                dp[i][previous_idx] = len;
            }

        }

        return dp[size][size];
    }
}
