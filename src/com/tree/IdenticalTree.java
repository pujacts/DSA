package com.tree;

public class IdenticalTree {
    private Node root;
    IdenticalTree(){
        this.root = null;
    }
    public static void main(String[] args) {
        IdenticalTree t1 = new IdenticalTree();
        t1.root = new Node(1);
        t1.root.left = new Node(2);
        t1.root.right = new Node(3);
        t1.root.left.left = new Node(4);
        t1.root.left.right = new Node(5);

        IdenticalTree t2 = new IdenticalTree();
        t2.root = new Node(1);
        t2.root.left = new Node(2);
        t2.root.right = new Node(3);
        t2.root.left.left = new Node(4);
        t2.root.left.right = new Node(5);

        System.out.println("Identical or not answer me : " + t1.identical(t1,t2));
    }

    private Boolean identical(IdenticalTree t1, IdenticalTree t2) {
        Node node1 = t1.root;
        Node node2 = t2.root;
        return isEqual(node1, node2);
    }

    private boolean isEqual(Node node1, Node node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        return (isEqual(node1.left, node2.left)
                && isEqual(node1.right, node2.right)
                && (node1.data == node2.data));
    }
}
