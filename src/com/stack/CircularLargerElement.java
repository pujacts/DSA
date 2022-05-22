package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class CircularLargerElement {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 8, 10, 2, 1, 15, 7};
        //using brute force
        int[] large = circularlargerElement(arr);
        for (int a : large) {
            System.out.print(a + ",");
        }
        System.out.println();
        //using stack
        int[] large1 = circularlargerElementStk(arr);
        for (int a : large1) {
            System.out.print(a + ",");
        }
    }

    private static int[] circularlargerElementStk(int[] arr) {
        int size = arr.length;
        int[] large = new int[size];
        Arrays.fill(large, -1);
        Stack<Integer> stk = new Stack<>();
        int curr, index;
        for(int i=0; i<2*size-1; i++){
            curr = arr[i%size];
            while(!stk.isEmpty() && arr[stk.peek()]<=curr){
                large[stk.pop()] = curr;
            }
            stk.push(i%size);
        }
        while(!stk.isEmpty()){
            large[stk.pop()] = -1;
        }
        return large;
    }

    private static int[] circularlargerElement(int[] arr) {
        int size = arr.length;
        int[] large = new int[size];
        Arrays.fill(large, -1);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] < arr[j]) {
                    large[i] = arr[j];
                    break;
                }
            }
            if(large[i]==-1) {
                for (int k = 0; k <i ; k++) {
                    if (arr[i] < arr[k]) {
                        large[i] = arr[k];
                        break;
                    }
                }
            }
        }
        return large;
    }
}
