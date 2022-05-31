package com.tree;

import java.util.Stack;

public class SpiralTree {
    private Node root;
    public SpiralTree(){
        this.root = null;
    }

    public static void main(String[] args) {
        SpiralTree tree = new SpiralTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        tree.printSpiralUsingRecursion();
        System.out.println(" ");
        tree.printSpiralTree();
    }

    private void printSpiralTree() {
        if(root == null){
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while(!s1.isEmpty()){
                Node temp = s1.pop();
                System.out.print(temp.data + " ");
                if(temp.right!=null){
                    s2.push(temp.right);
                }
                if(temp.left!=null){
                s2.push(temp.left);
                }

            }
             while(!s2.isEmpty()){
                 Node temp = s2.pop();
                 System.out.print(temp.data + " ");
                 if(temp.left!=null){
                     s1.push(temp.left);
                 }
                 if(temp.right!=null){
                     s1.push(temp.right);
                 }

             }
        }
    }

    private void printSpiralUsingRecursion() {
        Node curr = root;
        int h = height(curr);
        boolean ltr = false;
        int i;
        for(i=1; i<=h; i++){
            pritGivenLevel(curr, i, ltr);
            ltr = !ltr;
        }

    }

    private void pritGivenLevel(Node curr, int level, boolean ltr) {
        if(curr == null){
            return ;
        }
        if(level==1){
            System.out.print(curr.data + " ");
            return;
        }
        if(level>1){
            if(ltr){
                pritGivenLevel(curr.left , level-1, ltr);
                pritGivenLevel(curr.right , level-1, ltr);
            } else {
                pritGivenLevel(curr.right , level-1, ltr);
                pritGivenLevel(curr.left , level-1, ltr);
            }
        }
    }

    private int height(Node curr) {

        if(curr==null){
            return 0;
        }
        int lH = height(curr.left);
        int rH = height(curr.right);

        if(lH> rH){
            return lH+1;
        } else {
            return rH+1;
        }
    }
}
