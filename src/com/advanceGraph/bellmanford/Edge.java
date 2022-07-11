package com.advanceGraph.bellmanford;

public class Edge {

    private double weight;
    private Vertex source;
    private Vertex target;

    public Edge(double weight, Vertex source, Vertex target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }
}
