package com.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    private int V;
    LinkedList<LinkedList<Integer>> edge;

    TopologicalSort(int v){
        V = v;
        edge = new LinkedList<>();
        for(int i =0 ; i< V; i++){
            edge.add(new LinkedList<>());
        }
    }
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1 );

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }

    private void topologicalSort() {
        Stack<Integer> stk= new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i =0; i<V ; i++){
            if (!visited[i])
            topologicalSortUtil(i, visited, stk);
        }

        while(!stk.isEmpty()){
            System.out.print(stk.pop()+ " ");
        }

    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stk) {
        visited[v] = true;
        LinkedList<Integer> adj = edge.get(v);
        for(Integer a : adj){
            if(!visited[a]){
                topologicalSortUtil(a , visited, stk);
            }
        }
        stk.push(v);
    }

    private void addEdge(int v, int w) {
        edge.get(v).add(w);
    }
}
