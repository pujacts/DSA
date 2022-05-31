package com.tree;

import java.util.Stack;

public class PreOrderTraversal {

private Node root;

public PreOrderTraversal(){
    this.root = null;

}

    public static void main(String[] args) {
        PreOrderTraversal tree = new PreOrderTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.preOrderTraversal();
    }

    private void preOrderTraversal() {

        Stack<Node> stk = new Stack<>();

        Node curr = root;

        while(curr!=null || !stk.isEmpty()){
            while(curr!=null){
                System.out.print(curr.data+ " ");

                if(curr.right!=null){
                    stk.push(curr.right);
                }
                curr = curr.left;
            }
            if(!stk.isEmpty()){
                curr = stk.pop();
            }
        }


    }
}
