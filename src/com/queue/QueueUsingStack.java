package com.queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Character> stk1 = new Stack<>();
    Stack<Character> stk2 = new Stack<>();

    public void add(Character value){
        stk1.push(value);
    }
    public Character remove(){
        if(!stk2.isEmpty()){
            return stk2.pop();
        }
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        return stk2.pop();

    }

    public static void main(String[] args){
        QueueUsingStack queue = new QueueUsingStack();
        queue.add('D');
        queue.add('H');
        queue.add('E');
        queue.add('E');
        queue.add('R');
        queue.add('A');
        queue.add('J');
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
