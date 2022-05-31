package com.tree;

public class BinaryTreeSearch {

    private Node root;

    BinaryTreeSearch(){
        this.root = null;
    }
    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left.left = new Node(10);

        System.out.println("is Value present: " + tree.search(9));
        System.out.println("---------------------------------");
        System.out.println("is Value present: " + tree.search(50));
    }

    private boolean search(int value) {
        Node curr = root;
        return search(curr, value);
    }

    private boolean search(Node curr, int value) {
        if(curr == null){
            return false;
        }
        if(curr.data==value){
            return true;
        }
        boolean left = search(curr.left, value);
        if(left){
            return true;
        }
        boolean right = search(curr.right, value);
        if(right){
            return true;
        }
        return false;
    }
}
