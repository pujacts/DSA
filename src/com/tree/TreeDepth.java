package com.tree;

public class TreeDepth {
    private Node root;

    TreeDepth(){
        this.root = null;
    }
    public static void main(String[] args) {
        TreeDepth tree = new TreeDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(80);
        tree.root.left.left.left.left = new Node(90);

        System.out.println("Depth : " + tree.depth());

    }

    private int depth() {
        Node curr = root;
        return depth(curr);
    }

    private int depth(Node curr) {
        if(curr==null){
            return 0;
        }
        int left = depth(curr.left);
        int right = depth(curr.right);
        if(left> right){
            return left+1;
        } else {
            return right+1;
        }
    }

}
