package com.dynamic.programing;

public class KnapSack {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        boolean visited[] = new boolean[n];
       // int ans = solve(W, wt, val, n);
        int[][] dp = new int[n+1][W+1];
        int ans = solve(W, wt, val, n, dp);
        return ans;
    }

    static int solve(int W, int wt[], int val[], int n){
        if(W == 0 || n == 0) return 0;
        int ans = 0;
        if(wt[n-1]>W){
            ans = solve(W, wt, val, n-1);
            //return ans;
        } else {
            ans = Math.max(solve(W, wt, val, n-1) ,
                    solve(W-wt[n-1], wt, val, n-1)+val[n-1]);

            //return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int wt[] = {4, 5, 1};
        int val [] = {1, 2, 3};
        int W = 4;
        //System.out.println(knapSack(4, wt, val, 3));
        System.out.println(22%2);
        System.out.println(22/2);
        System.out.println(knapSack1(W, wt, val, 3));
    }

    static int solve(int W, int wt[], int val[], int n, int[][] dp){
        if(W == 0 || n == 0) return 0;
        if(dp[n][W]!=0) return dp[n][W];
        int ans = 0;
        if(wt[n-1]>W){
            dp[n][W] = solve(W, wt, val, n-1, dp);
            //return ans;
        } else {
            dp[n][W] = Math.max(solve(W, wt, val, n-1,dp) ,
                    solve(W-wt[n-1], wt, val, n-1, dp)+val[n-1]);

            //return ans;
        }
        return dp[n][W];
    }

    static int knapSack1(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i - 1] <= j){
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

}
