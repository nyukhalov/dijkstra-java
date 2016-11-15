package com.github.nyukhalov.dijkstra;

import com.github.nyukhalov.dijkstra.model.Edge;
import com.github.nyukhalov.dijkstra.model.Graph;
import com.github.nyukhalov.dijkstra.model.Vertex;

import java.util.*;

public class DijkstraAlgorithm {

    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {
        Objects.requireNonNull(graph);

        this.edges = new ArrayList<>(graph.getEdges());
    }

    /**
     * Computes and returns the shortest path from {@code source} to {@code target}
     * @param source a start vertex
     * @param target a destination vertex
     * @return the path from {@code source} to the {@code target}
     */
    public List<Vertex> getPath(Vertex source, Vertex target) {
        execute(source);
        return getPath(target);
    }

    /**
     * Returns the path from the source to the selected target or {@code null} if no path exists
     * @param target a selected target
     * @return the path from source to the {@code target}
     */
    public List<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;

        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }

        Collections.reverse(path);
        return path;
    }

    /**
     * Computes the shortest paths from {@code source} to each vertex
     * @param source a vertex to start from
     */
    public void execute(Vertex source) {
        Objects.requireNonNull(source);

        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();

        distance.put(source, 0);
        unSettledNodes.add(source);

        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    private void findMinimalDistances(Vertex node) {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
            else if (edge.getDestination().equals(node) && !isSettled(edge.getSource())) {
                neighbors.add(edge.getSource());
            }
        }
        return neighbors;
    }

    private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)
                    ||
                edge.getDestination().equals(node) && edge.getSource().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }
}
