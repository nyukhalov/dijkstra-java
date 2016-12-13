package com.github.nyukhalov.dijkstra.model;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

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
        graph.addEdge("A", "B", 0);

        assertEquals(1, graph.getEdges().size());
        assertEquals(2, graph.getVertexes().size());

        List<String> dataList = graph.getVertexes().stream()
                .map(Vertex::getData)
                .collect(Collectors.toList());

        assertTrue(dataList.contains("A"));
        assertTrue(dataList.contains("B"));
    }

    @Test
    public void testAddingEdge() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addEdge(new Edge<>("A", "B", 0));

        assertEquals(1, graph.getEdges().size());
        assertEquals(2, graph.getVertexes().size());

        List<String> dataList = graph.getVertexes().stream()
                .map(Vertex::getData)
                .collect(Collectors.toList());

        assertTrue(dataList.contains("A"));
        assertTrue(dataList.contains("B"));
    }

    @Test
    public void testAddingFewSameEdges() throws Exception {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B", 0);
        graph.addEdge("A", "B", 0);
        graph.addEdge("A", "B", 0);
        graph.addEdge("A", "B", 0);
        graph.addEdge("A", "B", 0);

        assertEquals(1, graph.getEdges().size());
        assertEquals(2, graph.getVertexes().size());

        List<String> dataList = graph.getVertexes().stream()
                .map(Vertex::getData)
                .collect(Collectors.toList());

        assertTrue(dataList.contains("A"));
        assertTrue(dataList.contains("B"));
    }
}