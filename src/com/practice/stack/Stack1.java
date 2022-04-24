package com.practice.stack;

public class Stack1 {

    private int top = -1;
    private int capacity ;
    private int[] data ;
    private int minCapacity;

    Stack1(){
       this(3);
    }

    public Stack1(int size) {
        data = new int[size];
        capacity = minCapacity = size;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int size(){
        return top+1;
    }
    public void print(){
        for(int i = size()-1 ; i>-1; i--){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public int top() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }

        return data[top];
    }
    public void push(int value){
        if(size() == capacity){
            int[] newData = new int[capacity*2];
            System.arraycopy(data, 0, newData , 0, capacity);
            data = newData;
            capacity = capacity*2;
        }
        top++;
        data[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }
        int topVal = data[top];
        top--;
        if(size()== capacity/2 && capacity> minCapacity){
            capacity = capacity/2;
            int[] newData = new int[capacity];
            System.arraycopy(data, 0, newData, 0, capacity);
            data = newData;
        }
        return  topVal;
    }

    public static void main(String[] args){

        Stack1 s = new Stack1();
        System.out.println("size of stack first time :"+ s.size());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("capacity of stack is : "+ s.capacity);
        s.print();
        System.out.println("popped element :"+ s.pop());
        s.print();
        System.out.println("capacity of stack is : "+ s.capacity);

    }
}
