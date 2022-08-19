package com.dynamic.programing;

import java.util.*;

public class LongestSubsequenceWithDiff1 {
    static int max[] = {Integer.MIN_VALUE};
    static int longestSubsequence(int N, int A[])
    {
        if(N == 1) return 1;
        for(int i = 0; i < N - 1; i++){
            List<Integer> result = new ArrayList<>();
            result.add(A[i]);
            longestSubsequence(N, A, A[i], result, 0, max);
        }
        return max[0];
    }

    static boolean longestSubsequence(int N, int A[], int curr, List<Integer> result,
                                      int index, int[] max)
    {
        if(index >= N){
            max[0] = Math.max(max[0], result.size());
            return true;
        }
        int a = 0, b = 0;
        if(Math.abs(curr - A[index]) == 1){
            result.add(A[index]);
            curr = A[index];
            if(longestSubsequence(N, A, curr, result, index + 1, max))
                return true;
        } else{
            if(longestSubsequence(N, A, curr, result, index + 1, max))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

  //      int A[] = {431,714,161,440,760,979,525,760,992,603,956,939,397,513,691,339,188,709,816,549,6,606,
   //             392,702,739,814,446,281,372,155,252,96,765,894,966,439,338,137,293,751,985,837,106,529,857,
    //            442,52,224,561,83,251,253,765,336,254,133,556,69,594,382,717,108,355,74,811,839,912,331,71,
     //           336,570,15,149,436,678,62,793};
        int A[] = { 1, 2, 3, 4, 5 };
        int N = A.length;
        System.out.println(longestSubsequence1(N, A));
    }

    static int longestSubsequence1(int N, int A[])
    {
        int dp[] = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < dp.length; j++){
                if(Math.abs(A[i] - A[j]) == 1){
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
