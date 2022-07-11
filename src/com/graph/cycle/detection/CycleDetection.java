package com.graph.cycle.detection;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");
        Vertex v3 = new Vertex("D");
        Vertex v4 = new Vertex("E");
        Vertex v5 = new Vertex("F");

        v5.addNeighbours(v0);

        v0.addNeighbours(v2);
        v0.addNeighbours(v4);

        v4.addNeighbours(v5);

        v2.addNeighbours(v1);
        v2.addNeighbours(v3);

        List<Vertex> graph = new ArrayList<>();
        graph.add(v4);
        graph.add(v3);
        graph.add(v0);
        graph.add(v5);
        graph.add(v2);
        graph.add(v1);

        CycleDetection cd = new CycleDetection();
        cd.detectCycle(graph);
    }
    public void detectCycle(List<Vertex> graph){
        for(Vertex vertex : graph){
            if(!vertex.isVisited())
                dfs(vertex);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);

        for(Vertex v : vertex.getNeighbours()){
            if(v.isBeingVisited()){
                System.out.println("backward edge.........cycle present");
                return;
            }
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
