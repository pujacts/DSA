package com.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaximumValueSlidingWindows {

    public static void main(String[] args) {
        int[] arr = {11,2,75,92,59,90,105,200};
        int k = 4;

        Object[] windowsList = findMaximum(arr, k);
        System.out.println(Arrays.toString(windowsList));

        System.out.println("----------------------------------");
        //Return an array
        int[] windowListArray = findMaximumReturnArray(arr, k);
        System.out.println(Arrays.toString(windowListArray));

    }

    private static int[] findMaximumReturnArray(int[] arr, int k) {

            int[] maxArray = new int[arr.length-k+1];

            for(int i = 0 ; i< arr.length-(k-1); i++){
                int max = Integer.MIN_VALUE;
                for(int j=i; j<i+k; j++){
                    max = Math.max(max, arr[j]);
                }
                maxArray[i] = max;
            }

            return maxArray;

        }

    private static Object[] findMaximum(int[] arr, int k) {

        List<Integer> maxList = new LinkedList<>();

        for(int i =0 ; i< arr.length-(k-1); i++){
            int max = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++){
                max = Math.max(max, arr[j]);
            }
            maxList.add(max);
        }
        Object[] obj = maxList.toArray();
        return obj;
    }
}
