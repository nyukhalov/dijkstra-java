package com.github.nyukhalov.dijkstra.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Graph<T> {
    private final List<Vertex<T>> vertexes = new ArrayList<>();
    private final List<Edge<T>> edges = new ArrayList<>();

    public List<Vertex<T>> getVertexes() {
        return vertexes;
    }

    public List<Edge<T>> getEdges() {
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
