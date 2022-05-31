package com.tree;

import java.util.Stack;

public class NthPostOrder {
    private Node root;

    public NthPostOrder(){
        this.root = null;
    }

    public static void main(String[] args) {
        NthPostOrder tree = new NthPostOrder();
        tree.root = new Node(25);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(18);
        tree.root.left.right = new Node(22);
        tree.root.right.left = new Node(24);
        tree.root.right.right = new Node(32);

        System.out.println("---------Through Iteration--------------");
        tree.nthPostOrder(5);

        System.out.println("---------Through Recursion--------------");
        tree.nthPostOrderRec(5);
    }

    private void nthPostOrderRec(int k) {
        int[] count = {0};
        nthPostOrderRec(root, k, count);
    }
    private void nthPostOrderRec(Node node, int index , int[] count) {
       if(node==null){
           return;
       }
       if(node!=null){
           if(node.left!=null){
               nthPostOrderRec(node.left, index, count );
           }
           if(node.right!=null){
               nthPostOrderRec(node.right, index, count );
           }
           count[0]++;
           if(count[0] == index){
               System.out.println(node.data );
               return;
           }



       }
    }

    private void nthPostOrder(int k) {
        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        int count  = 1;
        if(root==null){
            return;
        }
        stk1.push(root);
        while(!stk1.isEmpty()){
            Node temp = stk1.pop();
            stk2.push(temp);

            if(temp.left!=null){
                stk1.push(temp.left);
            }
            if(temp.right!=null){
                stk1.push(temp.right);
            }

        }
        while(!stk2.isEmpty()){
            Node temp = stk2.pop();
            if(count==k){
                System.out.println(temp.data);
            }
            count++;
        }
    }
}
