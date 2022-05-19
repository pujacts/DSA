package com.practice.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue = new ArrayDeque<>();
    public void push(int value){
        int size = queue.size();
        queue.add(value);
        for(int i=0; i<size; i++){
            int data = queue.remove();
            queue.add(data);
        }
    }

    public int pop(){
        if(queue.isEmpty()){
            System.out.println("No elements");
            return -1;
        }
        return queue.remove();
    }
    //returns top of the stack
    public int top(){
        if(queue.isEmpty()){

            return -1;
        }
        return queue.peek();
    }
    // Returns true if Stack is empty else false
    boolean isEmpty() {
        return queue.isEmpty();
    }
    public static void main(String[] args){
        StackUsingQueue s = new StackUsingQueue();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        s.pop();
        System.out.println("Top element :" + s.top());
    }
}
