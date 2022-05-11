package com.practice.stack;

import java.util.Stack;

public class StockSpanProblem {

    public static void main(String[] args){
        int[] arr = {6,5,4,3,2,4,5,7,9};
        //using brute force(o(n2))
        int[] value = stockspanRange(arr);
       for(int a : value){
           System.out.print(a + " ");
       }
        System.out.println(" ");
       //using stack time complexity:o(n) and space complexity: o(n)
      int[] value1 = stockSpanRangeUsingStack(arr);
        for(int a : value1){
            System.out.print(a + " ");
        }
    }

    private static int[] stockSpanRangeUsingStack(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        span[0] = 1;
        for(int i = 1; i<arr.length; i++){
            while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]){
                stk.pop();
            }
            span[i] = (stk.isEmpty()) ? i+1 : i-(stk.peek());
            stk.push(i);
        }
        return span;
    }

    private static int[] stockspanRange(int[] arr) {
        int[] span = new int[arr.length];
        span[0] = 1;
        for(int i=1; i<arr.length; i++){
            span[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(arr[j]<=arr[i]){
                    span[i]++;
                }
            }
        }
        return span;
    }
}
