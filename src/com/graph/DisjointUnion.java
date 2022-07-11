package com.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointUnion {

    private int vertex;
    private int edge;
    private List<Edge> edges;
    static class Edge{
        int src, dest;

        public Edge() {
           
        }
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public DisjointUnion(int v, int e) {
        this.vertex = v;
        this.edge = e;
        this.edges = new ArrayList<>();

    }

    public static void main(String[] args) {
        int V = 3;
        int E = 3;

        DisjointUnion graph = new DisjointUnion(V, E);

        // add edge 0-1
        graph.edges.add(new Edge(0, 1));
        // add edge 1-2
        graph.edges.add(new Edge(1, 2));
        // add edge 0-2
        graph.edges.add(new Edge(0, 3));

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }

    private int isCycle(DisjointUnion graph) {

        // Allocate memory for creating V subsets
        int[] parent = new int[graph.vertex];
        // Initialize all subsets as single element sets
        for(int i =0 ; i < graph.vertex; i++){
            parent[i] = -1;
        }
        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for(int i= 0; i< graph.edge; i++){

            int x = graph.find(parent, graph.edges.get(i).src);
            int y = graph.find(parent, graph.edges.get(i).dest);

            if(x==y) return 1;

            graph.union(parent, x, y);
        }
        return 0;
    }

    private void union(int[] parent, int x, int y) {
        parent[x] = y;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

}
