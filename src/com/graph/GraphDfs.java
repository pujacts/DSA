package com.graph;

import java.util.LinkedList;
import java.util.Stack;

public class GraphDfs {

    private int V;
    private LinkedList<LinkedList<Integer>> adj ;

    GraphDfs(int v){
        V = v;
        adj = new LinkedList<>();
        for(int i=0; i< v; i++){
            adj.add(new LinkedList());
        }
    }
    //function to add an edge to the graph
    public void addEdge(int v , int w){
        adj.get(v).add(w);
    }
    public void DFS(int s){

        boolean[] visited = new boolean[V];
        visited[s] = true;
        Stack<Integer> stk = new Stack<>();
        stk.push(s);
        while(!stk.isEmpty()){
            int curr = stk.pop();
            System.out.print(curr + " ");
            LinkedList<Integer> adjl = adj.get(curr);
            for(Integer a : adjl){
                if(!visited[a]){
                    visited[a] = true;
                    stk.push(a);
                }
            }
        }

    }

    public void DFSRec(int v){
        boolean[] visited = new boolean[V];
        dfsUtil(v, visited);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        LinkedList<Integer> adjl = adj.get(v);
        for(Integer a : adjl){
            if(!visited[a]){
                dfsUtil(a , visited);
            }
        }
    }
    private void DfsUnconnected(){
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfsUtil(i, visited);
            }
        }

    }

    // Driver Code
    public static void main(String args[])
    {
        GraphDfs g = new GraphDfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(1);
        System.out.println();
        System.out.println(
                "Following is Depth First Traversal  using Recursion"
                        + "(starting from vertex 2)");

        g.DFSRec(2);
        System.out.println();
        g.DfsUnconnected();

    }
}
