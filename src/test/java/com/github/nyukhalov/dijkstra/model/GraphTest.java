package com.github.nyukhalov.dijkstra.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {
    @Test
    public void testInitialState() throws Exception {
        Graph<String> graph = new Graph<>();

        assertTrue(graph.getEdges().isEmpty());
        assertTrue(graph.getVertexes().isEmpty());
    }

    @Test
    public void testAddingEdgeByVertexes() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addEdge(new Vertex<>("A"), new Vertex<>("B"), 0);

        assertEquals(1, graph.getEdges().size());
        assertEquals(2, graph.getVertexes().size());
        assertEquals(graph.getVertexes().get(0).getData(), "A");
        assertEquals(graph.getVertexes().get(1).getData(), "B");
    }

    @Test
    public void testAddingEdge() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addEdge(new Edge<>(new Vertex<>("A"), new Vertex<>("B"), 0));

        assertEquals(1, graph.getEdges().size());
        assertEquals(2, graph.getVertexes().size());
        assertEquals(graph.getVertexes().get(0).getData(), "A");
        assertEquals(graph.getVertexes().get(1).getData(), "B");
    }
}