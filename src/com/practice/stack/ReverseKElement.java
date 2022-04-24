package com.practice.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Reverse k element from the top of the stack
 */
public class ReverseKElement {

    public static void main(String[] args){
        ReverseKElement reverseStack = new ReverseKElement();
        java.util.Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.print("stack : " + s);
        System.out.println();
        int k = 3;
        reverseStack.reverse(s, k);
        System.out.print("stack after inserting new value : " + s);
    }

    private void reverse(Stack<Integer> s, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int i = 0;
        while(!s.isEmpty() && i<k) {
           que.add(s.pop());
           i++;
        }

        while(!que.isEmpty()){
            s.push(que.remove());
        }
    }
}
