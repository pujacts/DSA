package com.tree;

public class BST {
    private Node root;

    BST(){
        this.root = null;
    }

    public static void main(String[] args) {
        BST t = new BST();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        t.create(arr);
//        t.print();
        t.insertNode(2);
        t.insertNode(8);
        t.insertNode(3);
        t.insertNode(4);
        t.print();
        System.out.println();
        System.out.println("value present: "+ t.find(3));
        System.out.println("value present: " + t.find(6));
        System.out.println("minimum value :" + t.min());
        System.out.println("minimum value :" + t.findMinNode());
        System.out.println("max value :" + t.max());
        System.out.println(t.isBst());

    }

    private  boolean isBst() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node node , int min, int max){
        if(node == null){
            return true;
        }
        if(node.data < min || node.data>max){
            return false;
        }
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }

    private int max() {
        Node curr = root;

        if(curr == null){
            return Integer.MIN_VALUE;
        }
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.data;

    }

    private Node findMinNode() {
        Node curr = root;
        if(curr==null){
            return null;
        }
        while(curr.left!=null){

            curr = curr.left;
        }
        return curr;
    }

    private int min() {
        Node curr = root;
        if(curr==null){
            return -1;
        }
        while(curr.left!=null){

            curr = curr.left;
        }
        return curr.data;
    }

    private boolean find(int key) {
        Node curr = root;
        return find(key, curr);


    }

    private boolean find(int key, Node curr) {

        while(curr!=null){
            if(curr.data == key){
                return true;
            } else {
                if(curr.data > key){
                    curr = curr.left;
                } else{
                    curr = curr.right;
                }
            }
        }

        return false;
    }

    private void create(int[] arr) {

        root = create(arr, 0, arr.length-1);

    }

    private Node create(int[] arr, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node curr = new Node(arr[mid]);
        curr.left = create(arr, start, mid-1);
        curr.right = create(arr, mid+1, end);
        return curr;
    }

    private void print(){
        print(root);
    }
    private void print(Node curr){
        if(curr!=null){
            print(curr.left);
            System.out.print(curr.data + " ");
            print(curr.right);
        }
    }

    public void insertNode(int value){
        root = insertNode(root, value);
    }

    public Node insertNode(Node node , int value){
        if(node == null){
            node = new Node(null, null, value);
        } else {
            if(node.data > value){
                node.left = insertNode(node.left, value);
            } else {
                node.right = insertNode(node.right, value);
            }
        }
        return node;
    }
}
