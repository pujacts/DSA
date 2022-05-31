package com.tree;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class NthPreOrder {
    private Node root;
   // private AtomicInteger new AtomicInteger(count.incrementAndGet());

    public NthPreOrder(){
        this.root = null;
    }
    public static void main(String[] args) {
        NthPreOrder tree = new NthPreOrder();
        tree.root = new Node(25);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(18);
        tree.root.left.right = new Node(22);
        tree.root.right.left = new Node(24);
        tree.root.right.right = new Node(32);

        System.out.println("---------Through Iteration--------------");
       tree.findNthPreOrder(5);

        System.out.println("-----------Through recursion-----------");
        tree.findNthPreOrderRec(5);
    }

    private void findNthPreOrderRec(int k) {
        if(root==null){
            return;
        }
        int count = 1;
        nThPreOrder(root, new AtomicInteger(count), k);
    }

    private void nThPreOrder(Node node, AtomicInteger count, int index) {

        if(node == null){
            return;
        }
        if(count.get() == index){
            System.out.println(node.data);
            return;
        }

        if(node.left!=null){
            count.incrementAndGet();
            nThPreOrder(node.left, count, index);
        }
        if (node.right!=null){
            count.incrementAndGet();
            nThPreOrder(node.right,count, index);
        }
    }

    private void findNthPreOrder(int k) {
        Node curr = root;
        if(curr==null){
            return;
        }
        int count = 1;
        Stack<Node> stk = new Stack<>();
        stk.push(curr);
        while(!stk.isEmpty()){
            Node temp = stk.pop();

            if(count==k){
                System.out.println(temp.data + " ");
                break;
            }
            if(temp.right!=null){
                stk.push(temp.right);
            }
            if(temp.left!=null){
                stk.push(temp.left);
            }
            count++;
        }
    }
}
