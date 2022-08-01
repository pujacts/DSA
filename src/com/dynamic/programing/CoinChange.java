package com.dynamic.programing;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int ans = minCoin(coins, amount, dp);
        return ans==Integer.MAX_VALUE-1? -1 : ans;

    }

    public static int minCoin(int[] coins, int amount, int dp[]){

        if(amount == 0){
            return 0;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE-1;
        for(int coin: coins){
            if(amount-coin>=0){
                ans = Math.min(ans , minCoin(coins, amount-coin, dp)+1 );
            }

        }

        return dp[amount]= ans;

    }
}
