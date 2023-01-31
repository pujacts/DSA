package com.arrays;

public class ZerosOnesTwos {

    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0};
        sort012(arr, arr.length);
        for(int a : arr){
            System.out.println(a);
        }
    }

    private static void sort012(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        int mid = 0;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
