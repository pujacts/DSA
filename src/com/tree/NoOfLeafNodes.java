package com.tree;

import java.sql.SQLOutput;

public class NoOfLeafNodes {
    private Node root;

    NoOfLeafNodes(){
        this.root = null;
    }
    public static void main(String[] args) {
        NoOfLeafNodes tree = new NoOfLeafNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("no. of leaf node is: " + tree.countLeaf());
    }

    private int countLeaf() {
        Node curr = root;
        return countLeaf(curr);
    }

    private int countLeaf(Node curr) {
        if(curr==null){
            return 0;
        }
        if(curr.left==null && curr.right==null){
            return 1;
        }
        return countLeaf(curr.left) + countLeaf(curr.right);
    }
}
