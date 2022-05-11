package com.practice.stack;

import java.util.Stack;

public class AreaHistogram {
    public static void main(String[] args){
        int[] arr = { 2,1,5,6,2,3 };
        int value = getMaxArea(arr);
        System.out.println("area of histogram is :" + value);

        //using next smaller and previous smaller
        int value1 = getMaxArea1(arr);
        System.out.println("area of histogram is :" + value1);
    }

    private static int getMaxArea1(int[] nums) {
        int[] lessL = new int[nums.length];
        int[] lessR = new int[nums.length];
        int area = 0;

        if(nums.length == 1) return nums[0];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<lessR.length;i++) {
            while(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                lessR[st.pop()] = i;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            lessR[st.pop()] = lessR.length;
        }
        for(int i=lessL.length-1; i>=0; i--) {
            while(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                lessL[st.pop()] = i;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            lessL[st.pop()] = -1;
        }

        for(int i=0;i<nums.length;i++) {
            area = Math.max(area, (lessR[i]-lessL[i]-1) * nums[i]);
        }
        return area;
    }


    private static int getMaxArea(int[] arr) {
        int maxArea = Integer.MIN_VALUE;
        int currArea;
        int minHeight = 0;
        for(int i = 1; i<arr.length; i++){
            minHeight = arr[i];
            for(int j= i-1; j>=0; j--){
                if(arr[j] < minHeight){
                    minHeight = arr[j];
                }
                currArea = minHeight * (i-j +1);
                if(maxArea < currArea){
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }
}
