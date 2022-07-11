package com.advanceGraph.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class BellManFordAlgorithm {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public BellManFordAlgorithm(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    //Algorithm
    public void run(Vertex vertex){
        vertex.setDistance(0);

        //v-1 in the worst part the longest path contains V
        for(int i = 0; i< vertices.size()-1; i++){
            //Relaxatuon
            for(Edge e : edges){
                Vertex u = e.getSource();
                Vertex v = e.getTarget();
                if(u.getDistance() + e.getWeight() < v.getDistance()){
                    v.setDistance(u.getDistance() + e.getWeight());
                    v.setPredesccesor(u);
                }
            }
        }

        //if we make an additional relaxation ad we know that there is shorter path
        //than we that there is a negative cyccle
        for(Edge e : edges){
            if(e.getSource().getDistance()!= Double.MAX_VALUE){
                if(hasCycle(e)){
                    System.out.println("there is a negative cycle");
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge e) {
        return e.getSource().getDistance()+ e.getWeight()< e.getTarget().getDistance();
    }

    public void shortestPathTo(Vertex vertex){
        if(vertex.getDistance()== Double.MAX_VALUE){
            System.out.println("there is no path from source to destination");
        }
        Vertex actual = vertex;

        while(actual.getPredesccesor()!=null){
            System.out.println(actual);
            actual = actual.getPredesccesor();
        }
    }
    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(5, vertices.get(0), vertices.get(1)));
        edges.add(new Edge(2, vertices.get(1), vertices.get(2)));
        edges.add(new Edge(11, vertices.get(2), vertices.get(0)));
        
        
        BellManFordAlgorithm ba = new BellManFordAlgorithm(vertices, edges);
        ba.run(vertices.get(0));
        ba.shortestPathTo(vertices.get(2));

    }
}
