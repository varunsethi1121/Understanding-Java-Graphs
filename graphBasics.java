package GRAPHS;
import java.util.*;

public class graphBasics {
    // CREATING EDGE CLASS
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

    public static void main(String args[]) {
        int vertices = 4; // FIXED: The graph has 4 nodes (0, 1, 2, 3)

        // Array of ArrayLists to store adjacency lists
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] sampleGraph = new ArrayList[vertices];

        // Initialize adjacency lists
        for (int i = 0; i < vertices; i++) {
            sampleGraph[i] = new ArrayList<>();
        }

        /*
         * GRAPH STRUCTURE:
         * 
         *       0
         *       |
         *      (2)  
         *       |
         *       1
         *      / \
         *   (1)   (3)
         *    2 --- 3
         *      (4)
         */

        // ADDING ALL THE EDGES OF THE GRAPH (UNDIRECTED)
        sampleGraph[0].add(new Edge(0, 1, 2));
        sampleGraph[1].add(new Edge(1, 0, 2)); // Bidirectional

        sampleGraph[1].add(new Edge(1, 2, 1));
        sampleGraph[2].add(new Edge(2, 1, 1)); // Bidirectional

        sampleGraph[1].add(new Edge(1, 3, 3));
        sampleGraph[3].add(new Edge(3, 1, 3)); // Bidirectional

        sampleGraph[2].add(new Edge(2, 3, 4));
        sampleGraph[3].add(new Edge(3, 2, 4)); // Bidirectional

        // FINDING ALL NEIGHBORS OF NODE 1
        System.out.print("Neighbours of Node 1: ");
        // for (Edge e : sampleGraph[1]) {
        //     System.out.print(e.destination + " ");
        // }
        for(int i=0;i<sampleGraph[1].size();i++){
            Edge e = sampleGraph[1].get(i);
            System.out.print(e.destination + " ");
        }
    }
}
