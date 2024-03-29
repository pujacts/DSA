package com.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KSort {
    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        kSort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }

    private static void kSort(int[] arr, int n, int k) {

        if (arr == null || arr.length == 0) {
            return;
        }
        // min heap
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>();
        // if there are less than k + 1 elements present in the array
        int minCount = Math.min(arr.length, k + 1);
        // add first k + 1 items to the min heap
        for (int i = 0; i < minCount; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }

    // A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
