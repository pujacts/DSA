package com.tree;

public class BinaryTreeMax {
    private Node root;

    BinaryTreeMax(){
        this.root = null;
    }
    public static void main(String[] args) {
        BinaryTreeMax tree = new BinaryTreeMax();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(80);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left.left = new Node(6);

        System.out.println("max element in tree: " + tree.max());

    }

    private int max() {
        Node curr = root;
        return max(curr);
    }

    private int max(Node curr) {
        if(curr==null){
            return Integer.MIN_VALUE;
        }
        int max = curr.data;
        int left = max(curr.left);
        int right = max(curr.right);
        if(left> max){
            max = left;
        }
        if(right> max){
            max = right;
        }
        return max;

    }
}
