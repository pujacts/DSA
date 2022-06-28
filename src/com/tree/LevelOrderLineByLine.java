package com.tree;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderLineByLine {
    private Node root;
    public LevelOrderLineByLine(){
        this.root = null;
    }
    public static void main(String[] args) {
        LevelOrderLineByLine tree = new LevelOrderLineByLine();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.print();
    }

    private void print() {
        Queue<Node> que = new ArrayDeque<>();
        Node curr= root;
        int count = 0;

      if(curr!=null){
          que.add(curr);
          while(que.size()>0){
              count = que.size();
              while(count>0){
                  Node temp = que.remove();
                  System.out.print(temp.data+ " ");
                  if(temp.left!=null){
                      que.add(temp.left);
                  }
                  if(temp.right!=null){
                      que.add(temp.right);
                  }
                  count-=1;
              }
              System.out.println(" ");

          }

      }
    }
}
