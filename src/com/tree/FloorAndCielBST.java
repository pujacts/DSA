package com.tree;

public class FloorAndCielBST {

    private Node root;
    public static void main(String[] args)
    {
        FloorAndCielBST tree = new FloorAndCielBST();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);

        System.out.println( tree.Ceil(tree.root, 11));
    }

    private int Ceil(Node root, int value) {
        int ceil = Integer.MIN_VALUE;
        Node curr = root;
        if(curr == null){
            return -1;
        }

        while(curr!=null){
            if(curr.data == value){
                ceil = curr.data;
                break;
            } else   if(curr.data > value){
                ceil = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ceil;
    }
}
