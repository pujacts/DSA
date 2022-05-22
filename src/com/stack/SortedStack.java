package com.stack;

public class SortedStack {

    public static void main(String[] args){
        SortedStack sortedStack = new SortedStack();
        StackLL s = new StackLL();
        s.push(1);
        s.push(3);
        s.push(4);
        System.out.print("before inserting : ");
        s.print();
        sortedStack.sortedInsert(s,2);
        System.out.print("after inserting in sorted stack: ");
        s.print();
    }

    public void sortedInsert(StackLL s, int value) {

        if(s.isEmpty() || value > s.peek()){
            s.push(value);
            return;
        }
        int temp = s.pop();
        sortedInsert(s , value);
        s.push(temp);
    }
}
