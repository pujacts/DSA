package com.graph.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addNeighbor(new Edge(v0, v1, 1));
        v0.addNeighbor(new Edge(v0, v2, 0));

        v1.addNeighbor(new Edge(v1, v2, -11));

        DijkstraAlgo dj = new DijkstraAlgo();
        dj.computePath(v0);
        System.out.println("-------------------------");
        System.out.println(dj.fidShortestPath(v2));
    }


    public void computePath(Vertex source){
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);
        source.setDistance(0);

        while(!queue.isEmpty()){
            Vertex curr = queue.poll();
            for(Edge edge : curr.getAdj()){ // B
               double nayaDistance = edge.getCost() + curr.getDistance();
               if(nayaDistance < edge.getManzil().getDistance()){
                   queue.remove(edge.getManzil());// if present
                   edge.getManzil().setDistance(nayaDistance);
                   edge.getManzil().setPichla(curr);
                   queue.add(edge.getManzil());
               }
            }
        }
    }

    public List<Vertex> fidShortestPath(Vertex destination){
        List<Vertex> path = new ArrayList<>();
        for(Vertex vertex = destination; vertex != null; vertex = vertex.getPichla()){
            path.add(vertex);
        }
        Collections.reverse(path);
        return  path;
    }
}
