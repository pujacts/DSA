package com.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeSlidingWindows {

    public static void main(String[] args) {
        int[] arr = {13,-2,-6,10,-14,50,14,21};
        int k= 3;
        int[] mins = negativeSlidingWindows(arr, k);
        System.out.println(Arrays.toString(mins));
    }

    private static int[] negativeSlidingWindows(int[] arr, int k) {

        Deque<Integer> Qi = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int i ;
        for(i= 0; i<k; i++){
           if(arr[i]<0)
            Qi.add(i);
        }

        for(; i<arr.length; i++){
            if(!Qi.isEmpty())
            list.add(arr[Qi.peek()]);

            while(!Qi.isEmpty() && Qi.peek()<=i-k){
                Qi.remove();
            }
            if(arr[i]<0)
                Qi.add(i);

        }
        if(!Qi.isEmpty())
            list.add(arr[Qi.peek()]);
        else
            list.add(0);
        return list.stream().mapToInt(v->v).toArray();
    }
}
