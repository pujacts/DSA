package com.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {
    public static void main(String[] args){
        int[] arr  = {13,21,3,6,20,3};
        //using brute force
        int[] large = largerElement(arr);
        for(int a : large){
            System.out.print(a + ",");
        }
        System.out.println();
        //using stack
        int[] stk = largerElement2(arr);
        for(int a : stk){
            System.out.print(a + ",");
        }
}

    private static int[] largerElement2(int[] arr) {

        int size = arr.length;
        int[] large = new int[size];
        Arrays.fill(large, -1);
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(arr[i]<arr[j]){
                    large[i] = arr[j];
                    break;
                }
            }
        }
        return large;
    }

    private static int[] largerElement(int[] arr) {
        int size = arr.length;
        int[] large = new int[size];
        Arrays.fill(large, -1);
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[size-1]);
        for(int i= size-1; i>=0; i--){
            while(!stk.isEmpty() && stk.peek()<=arr[i]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                large[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        return large;
    }
    }
