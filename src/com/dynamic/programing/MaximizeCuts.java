package com.dynamic.programing;

import java.util.Arrays;

public class MaximizeCuts {
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y= 5;
        int z = 2;
        int max = maximizeCuts(n, x, y, z);
        System.out.println(max);
    }

    public static int maximizeCuts(int n, int x, int y, int z){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i=0; i<=n; i++){
            if(dp[i]==-1) continue;
            if(i+x<=n) {
                dp[i+x] = Math.max(dp[i+x], dp[i]+1);
            }
            if(i+y<=n) {
                dp[i+y] = Math.max(dp[i+y], dp[i]+1);
            }
            if(i+z<=n) {
                dp[i+z] = Math.max(dp[i+z], dp[i]+1);
            }
        }
        return dp[n] == -1?0:dp[n];
    }
}
