package edu.ashish.algorithms.sort;

import edu.ashish.model.GraphNode;

import java.util.Iterator;
import java.util.Stack;

import static edu.ashish.util.DSCreationUtil.*;

/**
 * Topological Sort. This is used only for DAG(Directed Acyclic Graph). This sorting sorts the linear ordering
 * of vertices in such a way that for every directed graph from u -> v, vertex u should always come first than v.
 * If graph is not a DAG then topological sorting is not possible.
 *
 * Time Complexity: O(V + E) which is O(n) just like DFS.
 * Space Complexity: O(V) where V is the number of vertices.
 */
public class TopologicalSort {

    public static void main(String[] args) {
        GraphNode graph = createDAG();
        Stack<Integer> stack = topologicalSort(graph);
        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static Stack<Integer> topologicalSort(GraphNode graph) {

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[graph.getNoOfVertices()];

        for (int vertex = 0; vertex < graph.getNoOfVertices(); vertex++) {
            if (!visited[vertex]) {
                topologicalUtil(graph, vertex, visited, stack);
            }
        }
        return stack;
    }

    private static void topologicalUtil(GraphNode graph, int vertex, boolean[] visited, Stack<Integer> stack) {

        visited[vertex] = true;

        Iterator<Integer> itr = graph.getEdge(vertex).iterator();
        Integer adjVertex;
        while(itr.hasNext()) {
            adjVertex = itr.next();
            if (!visited[adjVertex]) {
                topologicalUtil(graph, adjVertex, visited, stack);
            }
        }
        stack.push(vertex);
    }
}
