package com.arrays;

import java.util.LinkedList;
import java.util.List;

public class Rearrange {

    public static void main(String[] args) {
        int[] arr = {9 ,4 ,-2, -1, 5, 0, -5, -3, 2};

        rearrange(arr, arr.length);
    }

    private static void rearrange(int[] arr, int n) {
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        List<Integer> ab = new LinkedList<>();

        for(int i = 0; i<n ; i++){
            if(arr[i] >=0){
                a.add(arr[i]);
            } else {
                b.add(arr[i]);
            }
        }
        int i =0;
        int j = 0;
        while( i<a.size() || i< b.size()){
            if(i<a.size()){
                arr[j++] = a.get(i);
            }
            if(i<b.size()){
                arr[j++] = b.get(i);
            }
            i++;
        }

//        for(int i = 0; i<a.size() || i< b.size(); i++){
//            if(i<a.size()){
//                arr[i] = a.get(i);;
//            }
//            if(i<b.size()){
//                arr[i] = b.get(i);
//            }
//        }
//
//        arr = ab.stream()
//                .mapToInt(Integer::intValue)
//                .toArray();
    }
}
