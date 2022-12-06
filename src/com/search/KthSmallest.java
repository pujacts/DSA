package com.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int n = 6;
        int k = 3;
        int ans = kthSmallest(arr, 0, n-1, k);
        System.out.println(ans);

        //using set data structure
        kthSmallestSet(arr, k);
    }

    private static void kthSmallestSet(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for(int a : arr){
            set.add(a);
        }

        Iterator<Integer> itr = set.iterator();
        while(k>0){
            itr.next();
            k--;
        }
        System.out.println(itr.next());
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        Arrays.sort(arr);

        return arr[k-1];// time complexity nlogn
    }

    public static int findKthSmallest(int[] arr, int l, int r, int k){
        int mid = (l+r)/2;
        if(mid == k){
            return arr[k];
        }

        if(mid<k){
            l = mid+1;
        }
        if(mid>k){
            r = mid-1;
        }

        return findKthSmallest(arr, l, r, k);
    }
}
