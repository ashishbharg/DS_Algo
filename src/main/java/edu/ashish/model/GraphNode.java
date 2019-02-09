package edu.ashish.model;

import java.util.LinkedList;

public class GraphNode {

    private int vertices;

    private LinkedList<Integer> edges[];

    public GraphNode(int vertices) {
        this.vertices = vertices;
        edges = new LinkedList[this.vertices];
        for (int i = 0; i < vertices; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        edges[vertex1].add(vertex2);
    }

    public int getNoOfVertices() {
        return vertices;
    }

    public LinkedList<Integer> getEdge(int vertex) {
        return edges[vertex];
    }
}
