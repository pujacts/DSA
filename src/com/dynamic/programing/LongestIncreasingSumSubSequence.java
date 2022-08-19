package com.dynamic.programing;

import java.util.Arrays;

public class LongestIncreasingSumSubSequence {
    public static void main(String[] args) {
        int  N = 5;
        int arr[] = {1, 101, 2, 3, 100};
        System.out.println(maxSumIS(arr, N));
    }

    private static int maxSumIS(int[] arr, int n) {
        if(n==1) return arr[0];
        int[][] dp= new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int sum=0;
        return maxSum(arr, n, 0, -1, sum, dp);
    }

    private static int maxSum(int[] arr, int n, int i, int prev, int sum, int[][] dp) {

        if(i==n) return sum;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int excl = maxSum(arr, n, i+1, prev, sum, dp);
        int incl = sum;
        if(prev==-1 || arr[i] > arr[prev]){
            incl = maxSum(arr, n, i+1, i, sum+arr[i], dp);
        }

        return dp[i][prev+1] = Math.max(excl, incl);
    }
}
