package com.heap;

public class InsertionHeap {

    public static void main(String[] args) {
        // Final Heap will be:
        // 15
        //    /   \
        // 5     10
        //  / \   /
        // 2   4 3
        int[] arr = new int[20];
        // initializing some values
        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 4;
        // Current size of the array
        int n = 5;
        int key = 15;
        n = insertNode(arr, n, key);
        printArray(arr, n);
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private static int insertNode(int[] arr, int n, int key) {
        n = n+1;
        arr[n-1] = key;
        //heapify the new node
        heapify(arr, n, n-1);
        return n;
    }

    private static void heapify(int[] arr, int n, int i) {

        int parent = (i-1)/2;
        if(arr[parent]>0){
            if(arr[i]> arr[parent]){
                // swap arr[i] and arr[parent]
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                // Recursively heapify the parent node
                heapify(arr, n, parent);
            }
        }
    }
}
