package GRAPHS;

import java.util.ArrayList;

public class graphDFSAlgorithm {
    static class Edge {
        int source;
        int destination;
        int edgeWeight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.edgeWeight = w;
        }
    }
    public static void dfs(ArrayList<Edge>[] graph, int currentNode, boolean visited[]){
        System.out.print(currentNode + " ");
        visited[currentNode] = true;
        for(int i=0;i<graph[currentNode].size();i++){
            Edge e = graph[currentNode].get(i);
            if(!visited[e.destination]){
                dfs(graph, e.destination, visited);
            }
        }
    }
    public static void main(String args[]) {
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

        System.out.print("BFS Traversal starting from node 0: ");
        dfs(sampleGraph, 0, new boolean[vertices]);
    }
}
