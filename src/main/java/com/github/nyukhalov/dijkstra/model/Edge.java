package com.github.nyukhalov.dijkstra.model;

import java.util.Objects;

public class Edge<T> {
    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final int weight;

    public Edge(Vertex<T> source, Vertex<T> destination, int weight) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(destination);

        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than (or equals to) 0");
        }

        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
