package com.github.nyukhalov.dijkstra;

import com.github.nyukhalov.dijkstra.model.Edge;
import com.github.nyukhalov.dijkstra.model.Graph;
import com.github.nyukhalov.dijkstra.model.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DijkstraAlgorithmTest {
    private Graph<String> graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph<>();
    }

    @Test
    public void test1() throws Exception {
        graph.addEdge(createEdge("1", "2", 0));
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);

        List<Vertex> path = algorithm.getPath(new Vertex("1"), new Vertex("2"));

        assertNotNull(path);
        assertEquals(path.size(), 2);
        assertEquals(path.get(0).getData(), "1");
        assertEquals(path.get(1).getData(), "2");
    }

    @Test
    public void test2() throws Exception {
        graph.addEdge(createEdge("1", "2a", 10));
        graph.addEdge(createEdge("1", "2b", 0));
        graph.addEdge(createEdge("2a", "3", 5));
        graph.addEdge(createEdge("2b", "3", 5));
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);

        List<Vertex> path = algorithm.getPath(new Vertex("1"), new Vertex("3"));

        assertNotNull(path);
        assertEquals(path.size(), 3);
        assertEquals(path.get(0).getData(), "1");
        assertEquals(path.get(1).getData(), "2b");
        assertEquals(path.get(2).getData(), "3");
    }

    private Edge<String> createEdge(String source, String destination, int weight) {
        return new Edge<>(source, destination, weight);
    }
}