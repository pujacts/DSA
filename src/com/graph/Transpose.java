package com.graph;

import java.util.ArrayList;

public class Transpose {

    private int V = 5;
    private ArrayList<Integer> [] adj = new ArrayList[V];
    private ArrayList<Integer> [] tr = new ArrayList[V];

    Transpose(){
        for(int i = 0; i < V; i++)
        {
            adj[i] = new ArrayList<Integer>();
            tr[i] = new ArrayList<Integer>();
        }
    }
    public void addEdge(int u, int v, boolean choice){
        if(!choice){
            adj[u].add(v);
        } else {
            tr[u].add(v);
        }

    }

    // Function to print the graph representation
    public  void printGraph() {
        for(int i = 0; i < V; i++)
        {
            System.out.print(i + "--> ");
            for(int j = 0; j < tr[i].size(); j++)
                System.out.print(tr[i].get(j) + " ");
            System.out.println();
        }
    }


    public  void getTranspose() {
        for(int i = 0; i < V; i++)
            for(int j = 0; j < adj[i].size(); j++)
                addEdge(adj[i].get(j), i, true);
    }

    public static void main(String[] args) {

        Transpose t = new Transpose();
        t.addEdge(0, 1, false);
        t.addEdge(0, 4, false);
        t.addEdge(0, 3, false);
        t.addEdge(2, 0, false);
        t.addEdge(3, 2, false);
        t.addEdge(4, 1, false);
        t.addEdge(4, 3, false);

        // Finding transpose of the graph
        t.getTranspose();

        // Printing the graph representation
        t.printGraph();
    }
}

