package com.tree;

import java.util.Stack;

public class PostOrderTraversal {

    private Node root;

    public PostOrderTraversal(){
        this.root = null;
    }

    public static void main(String[] args) {
        PostOrderTraversal tree = new PostOrderTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.postOrderTraversal();
    }

    private void postOrderTraversal() {

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();
        if(root == null){
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
            System.out.print(stk2.pop().data + " ");
        }
    }


}
