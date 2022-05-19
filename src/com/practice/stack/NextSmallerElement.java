package com.practice.stack;

import java.util.Stack;

public class NextSmallerElement {

    public static void find(int nums[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        /// {3,10,5,1,15,10,7,6}
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] < stack.peek()){
                stack.push(nums[i]);
            } else {
                stack.push(-1);
            }
        }
        for(int i = stack.size() - 1; i >= 0; i--){
            System.out.print(stack.get(i)+",");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr  = {3,10,5,1,15,10,7,6};

        find(arr);
        System.out.println("-------------------");
        //using brute force
        int[] small = smallerElement(arr);
        for(int a : small){
            System.out.print(a + ",");
        }
        System.out.println();
        //using stack
        int[] stk = smallerElement2(arr);
        for(int a : stk){
            System.out.print(a + ",");
        }
}

    private static int[] smallerElement2(int[] arr) {
        int size = arr.length;
        int[] small = new int[size];
        small[size-1] = -1;
        java.util.Stack<Integer> stk = new Stack<>();
        stk.push(arr[size-1]);
        for(int i = size-1; i>=0; i--){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                small[i] = stk.pop();
            }
            if(stk.isEmpty()){
                small[i]=-1;
            } else{
                small[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        return small;
    }

    private static int[] smallerElement(int[] arr) {
        int size = arr.length;
        int[] small = new int[size];

        for(int i = 0; i<size; i++){
            small[i] = -1;
            for(int j=i+1; j<size; j++){
                if(arr[j]<arr[i]){
                    small[i] = arr[j];
                    break;
                }
            }
        }
        return small;
    }
    }
