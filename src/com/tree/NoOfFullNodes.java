package com.tree;

public class NoOfFullNodes {

    private Node root;

    NoOfFullNodes(){
        this.root = null;
    }
    public static void main(String[] args) {
        NoOfFullNodes tree = new NoOfFullNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left.left = new Node(10);

        System.out.println("no. of all node is: " + tree.getFullNode());
    }

    private int getFullNode() {
        Node curr = root;
        return getFullNode(curr);
    }

    private int getFullNode(Node curr) {
        if(curr==null){
            return 0;
        }
        int count = getFullNode(curr.left) + getFullNode(curr.right);
        if(curr.left!=null && curr.right!=null){
            count++;
        }
        return count;
    }
}
