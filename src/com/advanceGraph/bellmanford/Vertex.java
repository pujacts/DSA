package com.advanceGraph.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    
    //distance from source to vertex
    private double distance;

    //the previous vertex on the shortest path
    private Vertex predesccesor;
    private List<Edge> adjacencyList;

    public Vertex(String name){
        this.name = name;
        this.adjacencyList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredesccesor() {
        return predesccesor;
    }

    public void setPredesccesor(Vertex predesccesor) {
        this.predesccesor = predesccesor;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Edge> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void addNeighbour(Edge edge){
        this.adjacencyList.add(edge);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
