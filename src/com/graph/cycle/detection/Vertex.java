package com.graph.cycle.detection;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public List<Vertex> getNeighbours() {
        return adjacencyList;
    }

    public void setNeighbours(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name +
                '}';
    }

    public void addNeighbours(Vertex vertex){
        this.adjacencyList.add(vertex);
    }
}
