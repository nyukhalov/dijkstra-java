package com.github.nyukhalov.dijkstra.model;

import java.util.Objects;

public class Vertex<T> {
    private final T data;

    public Vertex(T data) {
        Objects.requireNonNull(data);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return Objects.equals(getData(), vertex.getData());

    }

    @Override
    public int hashCode() {
        return getData().hashCode();
    }
}
