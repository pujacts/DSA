package com.dynamic.programing;

import java.util.ArrayList;
import java.util.List;

public class ProductLessThanKSubSequence {

    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 2};
        int k = 50;
        List<Integer> list = new ArrayList();
        int ans = count(arr, arr.length, k, 0, 1L, list)-1;

        System.out.println("----------" + ans);
    }

    public static int count(int[] a, long n, long k, int i, Long product, List<Integer> list) {
        if (i == n) {
            if (product <= k ) {
                System.out.println(list);
                return 1;
            }
            return 0;
        }
        list.add(a[i]);
        int l = count(a, n, k, i + 1, product * a[i], list);
        list.remove(list.size() - 1);
        int r = count(a, n, k, i + 1, product, list);
        return l + r;
    }
}
