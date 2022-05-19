package com.practice.queue;

public class QueueCircularLL {

    private Node tail = null;
    private int size = 0;
    private Node head = null;
    private class Node{
        private Node next;
        private char value;

        Node(Node next , char value){
            this.value = value;
            this.next = next;
        }
    }

    private int size(){
        return size;
    }

    private boolean isEmpty() {
        return size==0;
    }

    public void add(char value){
        Node newNode = new Node(null, value);
        if(tail == null){
            head = newNode;
            tail = newNode;
            tail.next = newNode;

        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;

        }
        size++;
    }

    public char remove(){
        char value ;
        if(tail == tail.next){
            value = tail.value;
            tail = null;
        } else {

            value = tail.next.value;
            tail.next = tail.next.next;
            head = tail.next;
        }
        size--;
        return value;
    }

    public void print(){
        Node node = head;
        while(node.next!=tail.next){
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println(node.value + ",");
    }

    public void print_1(){
        Node temp = tail.next;
        while(temp != tail){
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.print(temp.value + ", ");
        System.out.println();
    }

    public static void main(String[] args){
        QueueCircularLL queue = new QueueCircularLL();
        queue.add('D');
        queue.add('H');
        queue.add('E');
        queue.add('E');
        queue.add('R');
        queue.add('A');
        queue.add('J');
        queue.print();
        System.out.println(queue.remove());
        queue.print();

        System.out.println("---------new Print ---------");
        queue.print_1();
    }
}
