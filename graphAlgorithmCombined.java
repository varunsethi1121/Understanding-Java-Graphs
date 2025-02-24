package GRAPHS;

import java.util.*;

public class GraphAlgorithmCombined {
    static class Edge {
        int source;
        int destination;
        int edgeWeight;

        public Edge(int s, int d, int wt) {
            this.source = s;
            this.destination = d;
            this.edgeWeight = wt;
        }
    }

    // BFS Traversal
    public static void breadthFirstSearch(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true; // Mark the source as visited

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            System.out.print(currentNode + " ");

            for (Edge e : graph[currentNode]) {
                if (!visited[e.destination]) {
                    visited[e.destination] = true;
                    q.add(e.destination);
                }
            }
        }
    }

    // DFS Traversal using Recursion
    public static void depthFirstSearch(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.destination]) {
                depthFirstSearch(graph, e.destination, visited);
            }
        }
    }

    // Path Existence Check using DFS
    public static boolean pathExistOrNot(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.destination]) {
                if (pathExistOrNot(graph, e.destination, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Abbreviations you can refer to:");
            System.out.println("'BSF' -> Breadth First Search.");
            System.out.println("'DFS' -> Depth First Search.");
            System.out.println("'FPE' -> Find if path exists or not.");
            System.out.print("Enter the abbreviation of the algorithm you want to perform: ");
            String enteredChoice = sc.nextLine().trim();

            int vertices = 7;
            @SuppressWarnings("unchecked")
            ArrayList<Edge>[] sampleGraph = new ArrayList[vertices];

            for (int i = 0; i < vertices; i++) {
                sampleGraph[i] = new ArrayList<>();
            }

            sampleGraph[0].add(new Edge(0, 1, 1));
            sampleGraph[0].add(new Edge(0, 2, 1));

            sampleGraph[1].add(new Edge(1, 0, 1));
            sampleGraph[1].add(new Edge(1, 3, 1));

            sampleGraph[2].add(new Edge(2, 0, 1));
            sampleGraph[2].add(new Edge(2, 4, 1));

            sampleGraph[3].add(new Edge(3, 1, 1));
            sampleGraph[3].add(new Edge(3, 4, 1));
            sampleGraph[3].add(new Edge(3, 5, 1));

            sampleGraph[4].add(new Edge(4, 2, 1));
            sampleGraph[4].add(new Edge(4, 3, 1));
            sampleGraph[4].add(new Edge(4, 5, 1));

            sampleGraph[5].add(new Edge(5, 3, 1));
            sampleGraph[5].add(new Edge(5, 4, 1));
            sampleGraph[5].add(new Edge(5, 6, 1));

            sampleGraph[6].add(new Edge(6, 5, 1));

            if (enteredChoice.equals("BSF")) {
                System.out.print("BFS traversal of the given graph is: ");
                breadthFirstSearch(sampleGraph, 0, new boolean[vertices]);
            } else if (enteredChoice.equals("DFS")) {
                System.out.print("DFS traversal of the given graph is: ");
                depthFirstSearch(sampleGraph, 0, new boolean[vertices]);
            } else if (enteredChoice.equals("FPE")) {
                System.out.print("Enter source node: ");
                int src = sc.nextInt();
                System.out.print("Enter destination node: ");
                int dest = sc.nextInt();
                boolean pathExists = pathExistOrNot(sampleGraph, src, dest, new boolean[vertices]);
                System.out.println("Path exists: " + pathExists);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
