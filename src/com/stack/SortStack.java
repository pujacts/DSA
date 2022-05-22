package com.stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args){
        SortStack sortStack = new SortStack();

        Stack<Integer> s = new Stack();
        s.push(3);
        s.push(1);
        s.push(4);
        s.push(2);
        System.out.print("before sorting : " + s);

        System.out.println();
//        //using recursion
//        sortStack.sort(s);
//        System.out.print("after sorting : " + s);

        //sort using iterative method
        sortStack.sortIteravtive(s);
        System.out.print("after sorting using iteratively: " + s);
    }

    private void sortIteravtive(Stack<Integer> s) {

        Stack<Integer> stk = new Stack<>();
        while(!s.isEmpty()){
            int temp = s.pop();
            while((!stk.isEmpty()) && (temp>stk.peek())){
                s.push(stk.pop());
            }
            stk.push(temp);
        }
        System.out.print("after sorting using iteratively: " + stk);
        while(!stk.isEmpty()){
            s.push(stk.pop());
        }
    }

    private void sort(Stack<Integer> s) {

        int temp;
        if(!s.isEmpty()){
            temp = s.pop();
            sort(s);
            sortedInsert(s, temp);
        }
    }

    public void sortedInsert(Stack<Integer> s, int value) {

        if(s.isEmpty() || value > s.peek()){
            s.push(value);
            return;
        }
        int temp = s.pop();
        sortedInsert(s , value);
        s.push(temp);
    }
}
