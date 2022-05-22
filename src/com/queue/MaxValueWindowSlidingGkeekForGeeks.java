package com.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValueWindowSlidingGkeekForGeeks {

        static void printMax(int arr[], int n, int k)
        {
            Deque<Integer> Qi = new LinkedList<Integer>();
            int i;
            for (i = 0; i < k; i++)
            {
                while (!Qi.isEmpty() && arr[i] >=
                        arr[Qi.peekLast()])
                    Qi.removeLast();
                Qi.addLast(i);
            }
            for (; i < n; i++)
            {
                System.out.print(arr[Qi.peek()] + " ");
                while ((!Qi.isEmpty()) && Qi.peek() <=
                        i - k)
                    Qi.removeFirst();
                while ((!Qi.isEmpty()) && arr[i] >=
                        arr[Qi.peekLast()])
                    Qi.removeLast();
                Qi.addLast(i);
            }
            System.out.print(arr[Qi.peek()]);
        }
        public static void main(String[] args)
        {
          //  int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
            int arr[] = { 1, 2, 3, 4, 5, 6 };
            // 78 90 90 90 89
            // 78 90 90 90 89
            int k = 3;
            printMax(arr, arr.length, k);
            System.out.println();
            int min = maxSlidingWindow(arr, k);
            System.out.println("minimum of maximum sliding windows:" + min);

        }

    public static int maxSlidingWindow(int[] arr, int k) {

        List<Integer> list = new LinkedList<>();
        Deque<Integer> qi = new LinkedList<Integer>();
        int i;
        for(i=0; i<k ; i++){
            while(!qi.isEmpty() && arr[i]>=arr[qi.peekLast()]){
                qi.removeLast();
            }
            qi.addLast(i);
        }

        for(; i<arr.length; i++){
            list.add(arr[qi.peek()]);
            while ((!qi.isEmpty()) && qi.peek() <=
                    i - k)
                qi.removeFirst();
            while ((!qi.isEmpty()) && arr[i] >=
                    arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        list.add(arr[qi.peek()]);
        return list.stream().mapToInt(v->v).min().orElse(-1);
    }

}

