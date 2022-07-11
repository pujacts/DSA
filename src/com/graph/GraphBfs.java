package com.graph;


import java.util.LinkedList;

//Directed Graph
public class GraphBfs {
    private int V;
    private LinkedList<LinkedList<Integer>> adj;

    GraphBfs(int v) {
        V = v;
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }
    //function to add an edge to the graph
    public void addEdge(int v , int w){
            adj.get(v).add(w);
        }

    // print BFS traversal from an given source

    public void BFS(int s){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> que = new LinkedList<>();
        visited[s] = true;
        que.add(s);
        while(!que.isEmpty()){
            s = que.poll();
            System.out.print(s+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            LinkedList<Integer> adl = adj.get(s);
            for(Integer a : adl){
                if(!visited[a]){
                    visited[a] = true;
                    que.add(a);
                }
            }

        }
    }

    public static void main(String args[])
    {
        GraphBfs g = new GraphBfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

}
