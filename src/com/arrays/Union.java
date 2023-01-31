package com.arrays;

public class Union {
    public static void main(String args[])
    {
        int arr1[] = { 1, 2, 4, 5, 6 };
        int arr2[] = { 2, 3, 5, 7 };
        int n = arr1.length;
        int m = arr2.length;
        doUnion(arr1, arr2, n, m);
    }

    private static void doUnion(int[] a, int[] b, int n, int m) {

        int count= 0;
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                count++;
                i++;

            } else if(a[i]>b[j]){
                count++;
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        while (i < n){
            count++;
            i++;
        }
        while (j < m){
            count++;
            j++;
        }
        System.out.println(count);
    }
}
