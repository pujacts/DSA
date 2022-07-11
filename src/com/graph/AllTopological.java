package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AllTopological {

    private int V;
    private LinkedList<LinkedList<Integer>> adj ;

    AllTopological(int v){
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
    public static void main(String[] args) {

        // Create a graph given in the above diagram
        AllTopological graph = new AllTopological(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("All Topological sorts");
        graph.allTopologicalSorts();
    }

    private void allTopologicalSorts() {
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];
        for(int i =0; i< V; i++){
            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }

        ArrayList<Integer> all = new ArrayList<>();
        allTopologicalSortsUtil(visited, indegree, all);

    }

    private void allTopologicalSortsUtil(boolean[] visited, int[] indegree, ArrayList<Integer> all) {

        boolean flag = false;
        for(int i =0; i< V; i++){
            if(!visited[i] && indegree[i]==0){
                // including in result
                visited[i] = true;
                all.add(i);
                for (int adjacent : this.adj.get(i)) {
                    indegree[adjacent]--;
                }
                allTopologicalSortsUtil(visited, indegree, all);
                // resetting visited, res and indegree for
                // backtracking
                visited[i] = false;
                all.remove(all.size() - 1);
                for (int adjacent : this.adj.get(i)) {
                    indegree[adjacent]++;
                }

                flag = true;
            }
        }

        // We reach here if all vertices are visited.
        // So we print the solution here
        if (!flag) {
            all.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
