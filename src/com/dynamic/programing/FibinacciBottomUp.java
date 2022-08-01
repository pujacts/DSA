package com.dynamic.programing;

import java.util.HashMap;
import java.util.Map;

public class FibinacciBottomUp {

    public int fib(int n){
        int result [] = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        for(int i = 3; i <= n; i++){
            fib(n, i, map);
        }
        return map.get(n);
    }

    private int fib(int n,  int index, Map<Integer, Integer> map){
        if(map.containsKey(index)) return map.get(index);
        map.put(index, (fib(n, (index - 1), map) + fib(n, (index - 2), map)));
        return map.get(index);
    }

    private int fibonacci(int n){
        if(n==0) return 0;
        if(n==1|| n==2) return 1;

        return fibonacci(n-1)+ fibonacci(n-2);
    }

    private int dpFib(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1]=dp[2]=1;
        for(int  i=3; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        FibinacciBottomUp fbu = new FibinacciBottomUp();
        System.out.println(fbu.fib(8));
        System.out.println(fbu.dpFib(8));
    }
}
