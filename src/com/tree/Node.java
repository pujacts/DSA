package com.tree;

public class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        left=right=null;
    }
    public Node(Node left, Node right, int data){
        this.left = left;
        this.right = right;
        this.data = data;

    }
}
