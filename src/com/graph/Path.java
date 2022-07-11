package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Path {

    private int V;
    private LinkedList<LinkedList<Integer>> adj;

    Path(int v){
        V = v;
        adj = new LinkedList<>();
        for(int i =0 ; i< V; i++){
            adj.add(new LinkedList<>());
        }
    }

    private void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }

    public static void main(String[] args) {
        Path path = new Path(5);
        path.addEdge(0,1);
        path.addEdge(0,2);
        path.addEdge(2,3);
        path.addEdge(1,3);
        path.addEdge(3,4);
        path.addEdge(1,4);
        System.out.println("Path Exist :" + path.isPathExistRec(0,4));
        System.out.println("Path Exist :" + path.isPathExist(2,0));
        path.printAllPaths(0,4);
    }

    private void printAllPaths(int src, int dest) {
        boolean[] isVisited = new boolean[V];
        LinkedList<Integer> paths = new LinkedList<>();
        paths.add(src);
        printAllPathsUtil(src,dest, isVisited, paths);
    }

    private void printAllPathsUtil(Integer src, Integer dest, boolean[] isVisited, LinkedList<Integer> paths) {
        if(src.equals(dest)){
            System.out.println(paths);
            return;
        }

        isVisited[src] = true;
        LinkedList<Integer> adjl = adj.get(src);
        for(Integer a : adjl){
            if(!isVisited[a]){
                paths.add(a);
                printAllPathsUtil(a, dest, isVisited, paths);
                paths.remove(a);

            }
        }
        isVisited[src] = false;
    }

    private boolean isPathExistRec(int source, int dest) {
        boolean[] visited = new boolean[V];
        dfsUtil(source, visited);
        return visited[dest];
    }

    private void dfsUtil(int source, boolean[] visited) {
        visited[source] = true;
        LinkedList<Integer> adjl = adj.get(source);
        for (Integer a : adjl){
            if(!visited[a]){
                dfsUtil(a, visited);
            }
        }
    }

    private boolean isPathExist(int source, int dest) {
        boolean[] visited = new boolean[V];
        visited[source] = true;
        Stack<Integer> stk = new Stack<>();
        stk.push(source);
        while (!stk.isEmpty()){
            int curr = stk.pop();
            LinkedList<Integer> adjl = adj.get(curr);
            for(Integer a : adjl){
                if(!visited[a]){
                    visited[a] = true;
                    stk.push(a);
                }
            }
        }
        return visited[dest];

    }
}
