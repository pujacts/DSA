package com.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinimumValueSlidingWIndows {

    public static void main(String[] args) {
        int[] arr = {11,2,75,92,59,90,55};
        int k= 3;
        int[] mins = minSlidingWindows(arr, k);
        System.out.println(Arrays.toString(mins));
    }

    private static int[] minSlidingWindows(int[] arr, int k) {

        Deque<Integer> Qi = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int i ;
        for(i= 0; i<k; i++){
            while(!Qi.isEmpty() && arr[i]<= arr[Qi.peekLast()]){
                Qi.removeLast();
            }
            Qi.addLast(i);
        }

        for(; i<arr.length; i++){
            list.add(arr[Qi.peek()]);

            while(!Qi.isEmpty() && Qi.peek()<=i-k){
                Qi.removeFirst();
            }
            while(!Qi.isEmpty() && arr[i]<= arr[Qi.peekLast()]){
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        list.add(arr[Qi.peek()]);
        return list.stream().mapToInt(v->v).toArray();
    }
}
