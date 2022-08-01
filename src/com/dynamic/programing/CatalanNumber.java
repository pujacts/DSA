package com.dynamic.programing;

public class CatalanNumber {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(prefixStrings(n));
    }

    public static int prefixStrings(int N)
    {
        long dp[]=new long[N+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= N; i++){
            int low = 0, high = i - 1;
            while(low <= i - 1){
                dp[i] = (dp[i] + (dp[low] * dp[high])) % 1000000007;
                low++;
                high--;
            }
        }
        return (int)dp[N]%1000000007;
    }
}
