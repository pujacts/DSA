package com.practice.stack;

import java.util.Stack;

public class PrevSmallerElement {
    public static void main(String[] args){
        int[] arr  = {4,10,5,8,20,15,3,12};
        //using brute force
        int[] small = smallerElement(arr);
        for(int a : small){
            System.out.print(a + ",");
        }
        System.out.println();
        //using stack
        int[] stk = smallerElementStk(arr);
        for(int a : stk){
            System.out.print(a + ",");
        }
    }

    private static int[] smallerElementStk(int[] arr) {
        int size = arr.length;
        int[] small = new int[size];
        small[0] = -1;
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        for(int i = 1; i<size; i++){
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
        small[0] = -1;
        for(int i = 1; i<size; i++){
            small[i] = -1;
            for(int j=i-1; j>=0; j--){
               if(arr[j]<arr[i]){
                   small[i] = arr[j];
                   break;
               }
            }
        }
        return small;
    }
}
