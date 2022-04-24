package com.practice.stack;

import java.util.Stack;

public class BottomInsert {
    public static void main(String[] args){
        BottomInsert insert = new BottomInsert();
        java.util.Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.print("stack : " + s);
        System.out.println();
        insert.bottom(s , 6);
        System.out.print("stack after inserting new value : " + s);
    }

    private void bottom(Stack<Integer> s, int value) {

        if(s.isEmpty()){
            s.push(value);
            return;
        }

        int temp = s.pop();
        bottom(s , value);
        s.push(temp);
    }
}
