package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    // Using DSU to quickly
    // tell whether adding edge
    // will form a cycle.
    static class DSU {

        // Declaring two arrays to hold
        // information about the parent and
        // rank of each node.
        private int parent[];
        private int rank[];

        // Constructor
        DSU(int n) {

            // Defining size of the arrays.
            parent = new int[n];
            rank = new int[n];

            // Initializing their values
            // with i's and 0s.
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

        }
        private int find(int node) {
            // If the node is the parent of
            // itself then it is the leader
            // of the tree.
            if (parent[node] == node) return node;

            return find(parent[node]);
        }

        public void union(int u, int v) {
            // Make u as a leader
            // of its tree.
            u=find(u);

            // Make v as a leader
            // of its tree.
            v=find(v);

            // If u and v are not equal,
            // because if they are equal then
            // it means they are already in
            // same tree and it does not make
            // sense to perform union operation.
            if(u!=v){
                //checking tree with smaller depth height
                if(rank[u]< rank[v]){
                    int temp = u;
                    u = v;
                    v = temp;
                }
                // Attaching lower rank tree
                // to the higher one.
                parent[v] = u;
                // If now ranks are equal
                // increasing rank of u.
                if(rank[u]==rank[v])
                    rank[u]++;
            }
        }
    }
    private int vertex;
    private int edge;

    private List<Edge> edges;

    public Kruskal(int v, int e) {
        this.vertex = v;
        this.edge = e;
        this.edges = new ArrayList<>();
    }

    public static void main(String[] args) {
        // Creating an object of Graph type.
        Kruskal g = new Kruskal(6, 9);

        // Adding 9 edges to make the same
        // graph as given in examples.
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 8);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 6);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 4, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 2);

        g.kruskalAlgorithm();

    }

    private void kruskalAlgorithm() {
        int sum = 0;
        DSU dsu = new DSU(vertex);
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for (int i = 0; i < vertex; i++) {
            int u = dsu.find(edges.get(i).src);
            int v = dsu.find(edges.get(i).dest);

            // Checking if adding edge with endpoints
            // u and v form a cycle.
            // If not
            if(u!=v){
                System.out.println("Adding edge "+ u +" <---> "+ v +" to MST");
                //Adding the weight of current edge to total
                sum = sum+edges.get(i).weight;
                //including the edge to the union
                dsu.union(u, v);
            } else {
                System.out.println("cycle present "+ u +" <---> "+ v +" to MST");
            }
            System.out.println("total sum of mst : " + sum);
        }
    }



    private void addEdge(int v, int e, int w) {
        edges.add(new Edge(v, e, w));
    }

    private static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }


}
