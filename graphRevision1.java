package GRAPHS;

import java.util.*;

public class graphRevision1 {
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

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {

            int verticesEntered = 5;
            @SuppressWarnings("unchecked")
            ArrayList<Edge>[] sampleGraph = new ArrayList[verticesEntered];
            for (int i = 0; i < verticesEntered; i++) {
                sampleGraph[i] = new ArrayList<>();
            }
            sampleGraph[0].add(new Edge(1, 3, 1));
            sampleGraph[0].add(new Edge(1, 4, 3));

            sampleGraph[1].add(new Edge(2, 3, 3));
            sampleGraph[1].add(new Edge(2, 4, 2));
            sampleGraph[1].add(new Edge(2, 5, 1));

            sampleGraph[2].add(new Edge(3, 1, 1));
            sampleGraph[2].add(new Edge(3, 2, 3));
            sampleGraph[2].add(new Edge(3, 4, 2));

            sampleGraph[3].add(new Edge(4, 1, 4));
            sampleGraph[3].add(new Edge(4, 2, 2));
            sampleGraph[3].add(new Edge(4, 3, 2));

            sampleGraph[4].add(new Edge(5, 2, 1));
            System.out.print("Enter the vertex whose neighbours you want to display: ");
            int neighbourVertex = sc.nextInt();
            System.out.print("Neighbours of vertex 2 are: ");
            for (int i = 0; i < sampleGraph[neighbourVertex].size(); i++) {
                Edge e = sampleGraph[neighbourVertex].get(i);
                System.out.print(e.destinationVertex + " ");
            }
        }
    }
}