package GRAPHS;

import java.util.*;

public class graphTraversalRevision {
    static class Edge {
        int edgeWeight;
        int sourceVertex;
        int destinationVertex;

        public Edge(int s, int d, int w) {
            this.edgeWeight = w;
            this.sourceVertex = s;
            this.destinationVertex = d;
        }
    }

    public static void breadthFirstSearch(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedArray = new boolean[graph.length];

        q.add(0);
        visitedArray[0] = true;

        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            System.out.print(currentVertex + " ");

            for (Edge e : graph[currentVertex]) {
                if (!visitedArray[e.destinationVertex]) {
                    q.add(e.destinationVertex);
                    visitedArray[e.destinationVertex] = true;
                }
            }
        }
        System.out.println();
    }

    public static void depthFirstSearch(ArrayList<Edge>[] graph, int currentVertex, boolean[] visitedArray) {
        System.out.print(currentVertex + " ");
        visitedArray[currentVertex] = true;

        for (Edge e : graph[currentVertex]) {
            if (!visitedArray[e.destinationVertex]) {
                depthFirstSearch(graph, e.destinationVertex, visitedArray);
            }
        }
    }

    public static void main(String args[]) {
        int vertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graphSample = new ArrayList[vertices];
        for (int i = 0; i < graphSample.length; i++) {
            graphSample[i] = new ArrayList<>();
        }

        // Corrected Edge Assignments
        graphSample[0].add(new Edge(0, 1, 1));
        graphSample[0].add(new Edge(0, 2, 3));

        graphSample[1].add(new Edge(1, 3, 3));
        graphSample[1].add(new Edge(1, 4, 2));
        graphSample[1].add(new Edge(1, 5, 1));

        graphSample[2].add(new Edge(2, 3, 1));
        graphSample[2].add(new Edge(2, 4, 3));

        graphSample[3].add(new Edge(3, 5, 2));
        graphSample[3].add(new Edge(3, 6, 4));

        graphSample[4].add(new Edge(4, 6, 1));

        System.out.print("Breadth First Traversal is: ");
        breadthFirstSearch(graphSample);

        System.out.print("Depth First Traversal is: ");
        depthFirstSearch(graphSample, 0, new boolean[vertices]);
        System.out.println();
    }
}
