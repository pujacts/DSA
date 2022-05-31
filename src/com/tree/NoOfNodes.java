package com.tree;

public class NoOfNodes {
    private Node root;

    public NoOfNodes(){
        this.root = null;
    }

    public static void main(String[] args) {
        NoOfNodes tree = new NoOfNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        System.out.println("no of nodes : " + tree.numOfNodes());
        System.out.println("sum of nodes : " + tree.sumOfNodes());

    }

    private int sumOfNodes() {
        Node curr = root;
        return sumOfNodes(curr);
    }

    private int sumOfNodes(Node node) {
        if(node == null){
            return 0;
        } else {
            return (node.data + sumOfNodes(node.left)+ sumOfNodes(node.right));
        }
    }

    private int numOfNodes( ) {
        Node curr = root;
        return numOfNodes(curr);

    }

    private int numOfNodes(Node node) {
        if(node==null) {
            return 0;
        } else
            return (1 + numOfNodes(node.left) + numOfNodes(node.right));
    }
}
