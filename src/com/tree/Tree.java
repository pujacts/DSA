package com.tree;

public class Tree {

    public Node root;

    public void completeBinaryTree(int[] arr) {
        root = levelOrderBinaryTree(arr, 0);
    }

    private Node levelOrderBinaryTree(int[] arr, int start) {
        Node curr = new Node(arr[start]);
        int left = 2*start+1;
        int right = 2*start+2;

        if(left< arr.length){
            curr.lChild = levelOrderBinaryTree(arr, left);
        }
        if(right< arr.length){
            curr.rchild = levelOrderBinaryTree(arr, right);
        }

        return curr;
    }

    public void printPreOrder(){
        printPreOrder(root);
        System.out.println();
    }
    public void printPreOrder(Node node){
        if(node!=null){
            System.out.print(node.data+ " ");
            printPreOrder(node.lChild);
            printPreOrder(node.rchild);
        }
    }

    public void printPostOrder(){
        printPostOrder(root);
        System.out.println();
    }
    public void printPostOrder(Node node){
        if(node!=null){
            printPostOrder(node.lChild);
            printPostOrder(node.rchild);
            System.out.print(node.data + " ");
        }
    }

    public void printInOrder(){
        printInOrder(root);
        System.out.println();
    }
    public void printInOrder(Node node){
        if(node!=null){
            printInOrder(node.lChild);
            System.out.print(node.data + " ");
            printInOrder(node.rchild);

        }
    }

    private static class Node{
        private Node lChild;
        private Node rchild;
        private int data;

        public Node(int data){
            this.data = data;
            this.rchild = null;
            this.lChild = null;
        }

        public Node(Node lChild, Node rchild, int data) {
            this.lChild = lChild;
            this.rchild = rchild;
            this.data = data;
        }
    }

    public Tree(){
        this.root = null;
    }
}
