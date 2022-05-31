package com.tree;

import java.util.Stack;

public class AllPathRootToLeaf {

    private Node root;
    public AllPathRootToLeaf(){
        this.root = null;
    }

    public static void main(String[] args) {
        AllPathRootToLeaf tree = new AllPathRootToLeaf();
        tree.root = new Node(25);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(18);
        tree.root.left.right = new Node(22);
        tree.root.right.left = new Node(24);
        tree.root.right.right = new Node(32);

        tree.printAllPath();
    }

    private void printAllPath() {
        Stack<Integer> path = new Stack<>();
        printAllPath(root, path);
    }

    private void printAllPath(Node node, Stack<Integer> path) {
        if(node==null){
            return;
        }
        path.push(node.data);
        if(node.left==null || node.right==null){
            System.out.println(path);
            path.pop();
            return;
        }
        printAllPath(node.left, path);
        printAllPath(node.right, path);
        path.pop();
    }
}
