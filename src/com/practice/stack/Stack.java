package com.practice.stack;

/**@implSpec  stack using fixed array
 *
 */
public class Stack {
    private int top = -1;
    private int capacity = 1000;
    private int[] data ;

    private Stack(){
        data = new int[capacity];
    }

    public Stack(int size){
        data = new int[size];
    }

    public boolean isEmpty(){
        return (top==-1);
    }
    public int size(){
        return top+1;
    }
    public void push(int value) throws IllegalStateException{
        if(data.length==size()){
            throw new IllegalStateException("StackOverflowError");
        }
        top++;
        data[top] = value;
    }

    public int pop() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }
        int topVal = data[top];
        top--;
        return topVal;
    }

    public int top() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }

        return data[top];
    }
    public void print(){
        for(int i = top ; i>-1; i--){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.print();
        System.out.println("popped element :"+ s.pop());
        s.print();
        System.out.println("size of stack :"+ s.size());
    }
}
