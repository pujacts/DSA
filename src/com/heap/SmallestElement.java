package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SmallestElement {

    public static void main(String[] args) {
        int []arr = {10, 5, 4 , 3 ,48, 15, 6 , 2 , 33, 53, 10};
        int k = 4;
        int smallest = findSmallest(arr, k);
        System.out.println(smallest);
        int largest = findLargest(arr, k);
        System.out.println(largest);
    }

    private static int findLargest(int[] arr, int k) {

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i =0; i< k; i++){
            que.add(arr[i]);
        }

        for(int i =k ; i< arr.length; i++){
            if(arr[i]> que.peek()){
                que.poll();
                que.add(arr[i]);
            }
        }

        return que.peek();
    }


    private static int findSmallest(int[] arr, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i< k; i++){
            que.add(arr[i]);
        }

        for(int i =k ; i< arr.length; i++){
            if(arr[i]< que.peek()){
                que.poll();
                que.add(arr[i]);
            }
        }

        return que.peek();
    }
}
