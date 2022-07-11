package com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class TransitiveClosure {

    // No. of vertices in graph
    private int vertices;

    // adjacency list
    private ArrayList<Integer>[] adjList;

    // To store transitive closure
    private int[][] result;

    // Constructor
    public TransitiveClosure(int vertices) {

        // initialise vertex count
        this.vertices = vertices;
        this.result = new int[this.vertices][this.vertices];

        // initialise adjacency list
        initAdjList();
    }

    // utility method to initialise adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList() {

        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // add edge from u to v
    public void addEdge(int u, int v) {
        // Add v to u's list.
        adjList[u].add(v);
    }

    // Driver Code
    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        TransitiveClosure g = new TransitiveClosure(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");

        g.transitiveClosure();

    }

    private void transitiveClosure() {
        for(int i = 0; i< vertices; i++){
            dfsUtils(i, i);
        }


        for (int i = 0; i < vertices; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private void dfsUtils(int s, int v) {
        result[s][v] = 1;

        for(Integer a : adjList[v]){
            if(result[s][a]==0){
                dfsUtils(s, a);
            }
        }

    }
}
