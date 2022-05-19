package com.practice.queue;

public class QueueCircularArray<T extends Object> {

    int capacity = 10;
    int size ;
    int back = 0; // to add
    int front = 0; // to remove
    T[] data;

    QueueCircularArray(){
      size = 0;
      this.data = (T[]) new Character[capacity];
    }

    public boolean add(Character value){
       if(size>=capacity){
           System.out.println("Queue is full, please try after sometime");
           return false;
       } else {
           data[back] = (T) value;
           size++;
           back = (++back) % (capacity - 1);
           return true;
       }

    }

    public Object remove(){
        if(size<=0){
            System.out.println("Queue is empty");
            return -999;
        }
        T value = data[front];
        size--;
        front = (++front) % (capacity-1);
        return value;
    }
    public void print(){
        for(int i =0 ; i< size; i++){
            System.out.println(data[i]);
        }
    }
    public static void main(String[] args){
        QueueCircularArray queue = new QueueCircularArray();
        queue.add('D');
        queue.add('H');
        queue.add('E');
        queue.add('E');
        queue.add('R');
        queue.add('A');
        queue.add('J');
        queue.print();

        System.out.println(queue.remove());
    }
}
