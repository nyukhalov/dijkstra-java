package com.github.nyukhalov.dijkstra.model;

import java.util.*;

public class Graph<T> {
    private final Set<Vertex<T>> vertexes = new HashSet<>();
    private final Set<Edge<T>> edges = new HashSet<>();

    public Set<Vertex<T>> getVertexes() {
        return vertexes;
    }

    public Set<Edge<T>> getEdges() {
        return edges;
    }

    public void addEdge(T source, T destination, int weight) {
        addEdge(new Edge<>(source, destination, weight));
    }

    public void addEdge(Edge<T> edge) {
        Objects.requireNonNull(edge);

        Vertex<T> source = edge.getSource();
        Vertex<T> destination = edge.getDestination();
        Objects.requireNonNull(source);
        Objects.requireNonNull(destination);

        vertexes.add(source);
        vertexes.add(destination);

        edges.add(edge);
    }
}
