package com.tree;

import java.util.Stack;

public class InOrderTreeTraversal {

    private Node root;
    public InOrderTreeTraversal(){
        this.root = null;
    }

    void inOrder(){
        if(root == null){
            return;
        }
        Stack<Node> stk = new Stack<>();
        Node curr = root;
        while(curr!=null || stk.size()>0){

            while(curr!=null){
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
    public static void main(String[] args) {
        InOrderTreeTraversal tree = new InOrderTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inOrder();
    }
}
