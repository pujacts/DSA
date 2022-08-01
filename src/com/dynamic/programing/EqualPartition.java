package com.dynamic.programing;

public class EqualPartition {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 6};
        int N = 4;
        int ans = equalPartition(N, arr);
        if(ans ==1 ) System.out.println(true);
        else System.out.println(false);
    }

    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < N; i++)
            sum = sum + arr[i];
        if(sum % 2 !=0) return 0;
        return equal(arr, sum/2, 0);
    }

    static int equal(int arr[], int sum , int i){
        if(sum==0) return 1;

        if(arr.length == 0  || arr.length <= i){
            return 0;
        }

        if(arr[i]<=sum)
        if(equal(arr, sum-arr[i] , i+1)==1){
            return 1;
        }


        return equal(arr, sum , i+1);
    }

    static int equalPartition1(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < N; i++)
            sum = sum + arr[i];
        if(sum % 2 !=0) return 0;
        int[][] dp = new int[N][sum/2+1];
        return equal(arr, sum/2, 0, dp);
    }

    static int equal(int arr[], int sum , int i, int[][] dp){
        if(sum == 0) return 1;

        if(sum < 0  || i >= arr.length ){
            return 0;
        }


        if(dp[i][sum]==0)
            if(equal(arr, sum-arr[i] , i+1, dp)==1){
                dp[i][sum]=1;
                return 1;
            }

        dp[i][sum] =  equal(arr, sum, i + 1, dp);
        return dp[i][sum];
    }

    static int equalPartition3(int N, int arr[])
    {
        int sum = 0;
        for(int in : arr){
            sum += in;
        }
        if(sum % 2 != 0) return 0;
        sum /= 2;

        boolean dp[][] = new boolean[N + 1][sum + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] =   dp[i - 1][j];
                }
            }
        }
        return dp[N][sum] == true ? 1 : 0;
    }
}
