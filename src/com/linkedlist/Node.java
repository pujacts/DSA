package com.linkedlist;

public class Node {
    public int val;
    public Node next;

    Node(){}
    Node(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{val = " + val + "}";
    }
}
