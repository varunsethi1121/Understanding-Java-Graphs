package GRAPHS;
import java.util.*;

public class graphHasPath {
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
    public static boolean hasPath(ArrayList<Edge>[] g, int s, int d, boolean[] visited){
        if(s == d){
            return true;
        }
        visited[s] = true;
        for(int i=0;i<g[s].size();i++){
            Edge e = g[s].get(i);
            if(!visited[e.destination] && hasPath(g, e.destination, d, visited)){
                return true;
            }
        }
        return false;
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
        // sampleGraph[5].add(new Edge(5, 6, 1));

        // sampleGraph[6].add(new Edge(6, 5, 1));

        System.out.print("Path that you are looking for is present in the entered graph: " + hasPath(sampleGraph, 0, 6, new boolean[vertices]));
    }
}

