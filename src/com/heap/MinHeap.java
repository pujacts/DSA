package com.heap;

import java.util.Arrays;

public class MinHeap {
    public static void main(String[] args) {
        int num[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        buildHeap(num);
        System.out.println("--------------------Print heap----------------");
        System.out.println(Arrays.toString(num));
        print(num);
    }

    private static void print(int[] num) {
        for (int i = 0; i <= num.length / 2; i++) {
            System.out.print(
                    " PARENT : " + num[i] + " LEFT CHILD : " + ((2 * i + 1) < num.length ? (num[2 * i + 1]) : null)
                            + " RIGHT CHILD :" + ((2 * i + 2) < num.length ? (num[2 * i + 2]) : null));
            System.out.println();
        }
    }

    private static void buildHeap(int[] num) {
        int startIdx = (num.length-1)/2;
        for(int i = startIdx; i>=0; i--){
            heapify(num, i);
        }
    }

    private static void heapify(int[] num, int i) {
        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < num.length && num[left]< num[min]){
            min = left;
        }
        if(right < num.length && num[right]< num[min]){
            min = right;
        }
        if(min!=i){
            swap(num, min, i);
            heapify(num, min);
        }
    }

    private static void swap(int[] arr, int min, int i) {
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
    }
}
