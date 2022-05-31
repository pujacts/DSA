package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSTraversal {

    private Node root;

    public BFSTraversal(){
        this.root = null;
    }

    public static void main(String[] args) {
        BFSTraversal tree= new BFSTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        tree.bfstTraversal();
    }

    private void bfstTraversal() {

        Queue<Node> que = new ArrayDeque<>();
        Node curr = root;
        que.add(curr);
        while(!que.isEmpty()){
            Node temp = que.remove();
            System.out.print(temp.data + ",");
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
        }
    }
}
