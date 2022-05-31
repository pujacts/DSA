package com.tree;

public class CompleteBinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        tree.completeBinaryTree(arr);
        tree.printPreOrder();
        System.out.println();
        tree.printPostOrder();
        System.out.println();
        tree.printInOrder();
    }
}
