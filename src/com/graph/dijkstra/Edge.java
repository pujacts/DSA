package com.graph.dijkstra;

public class Edge {

    private double cost;
    private Vertex shuru;
    private Vertex manzil;

    public Edge(Vertex startVertex, Vertex targetVertex, double distance) {
        this.cost = distance;
        this.shuru = startVertex;
        this.manzil = targetVertex;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double weight) {
        this.cost = weight;
    }

    public Vertex getShuru() {
        return shuru;
    }

    public void setShuru(Vertex startVertex) {
        this.shuru = startVertex;
    }

    public Vertex getManzil() {
        return manzil;
    }

    public void setmanzil(Vertex targetVertex) {
        this.manzil = targetVertex;
    }
}
