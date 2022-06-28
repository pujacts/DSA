package com.heap;

public class DeletionHeap {

    public static void main(String[] args) {
        // Array representation of Max-Heap
        // 10
        //    /  \
        // 5    3
        //  / \
        // 2   4
        int[] arr = {10,5,3,2,4};
        int n = arr.length;
        n = deleteRoot(arr, n);
        printArray(arr, n);
    }

    private static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private static int deleteRoot(int[] arr, int n) {
        int lastElement = arr[n-1];
        arr[0] = lastElement;
        n = n-1;

        //heapify the root node
        heapify(arr, n, 0);
        return n;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        // if left child is larger than root
        if(l<n && arr[l]> arr[largest]){
            largest = l;
        }
        if(r<n && arr[r]> arr[largest]){
            largest = r;
        }
        //if largest is not root
        if(largest!=i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
