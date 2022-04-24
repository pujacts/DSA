package com.practice.stack;

public class StackLL {
    private Node head = null;
    private int size = 0;
    private static class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this(value);
            this.next = next;
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int peek() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }
        return head.value;
    }
    public void push(int value){
       head = new Node(value, head);
       size++;
    }

    public int pop() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("StackEmptyException");
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }
   public void insertAtBottom(int value){
       if(isEmpty()){
          push(value);
          return;
       }
       int temp = pop();
       insertAtBottom(value);
       push(temp);
   }

   public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
       System.out.println();
   }

    public static void main(String[] args){
        StackLL s = new StackLL();
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
