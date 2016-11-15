package com.github.nyukhalov.dijkstra.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VertexTest {
    @Test
    public void testEquals() throws Exception {
        assertEquals(new Vertex<>("First"), new Vertex<>("First"));
        assertNotEquals(new Vertex<>("First"), new Vertex<>("Second"));
    }
}