package com.practice.stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        ReverseStack rev = new ReverseStack();
        java.util.Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.print("stack : " + s);
        System.out.println();
        rev.reverse(s);
        System.out.print("stack after inserting new value : " + s);
    }

    private void reverse(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        reverse(s);
         insert(s, temp);

    }

    private void insert(Stack<Integer> s, int value) {
        if (s.isEmpty()) {
            s.push(value);
            return;
        }
        int temp = s.pop();
        insert(s, value);
        s.push(temp);
    }
}
