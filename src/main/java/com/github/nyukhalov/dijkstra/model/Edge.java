package com.github.nyukhalov.dijkstra.model;

import java.util.Objects;

public class Edge<T> {
    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final int weight;

    public Edge(T source, T destination, int weight) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(destination);

        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than (or equals to) 0");
        }

        this.source = new Vertex<>(source);
        this.destination = new Vertex<>(destination);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge<?> edge = (Edge<?>) o;

        if (getWeight() != edge.getWeight()) return false;
        if (!getSource().equals(edge.getSource())) return false;
        return getDestination().equals(edge.getDestination());

    }

    @Override
    public int hashCode() {
        int result = getSource().hashCode();
        result = 31 * result + getDestination().hashCode();
        result = 31 * result + getWeight();
        return result;
    }
}
