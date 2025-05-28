package baekjoon.algorithm.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
        // value < 0, when x < y;
        // value == 0, when x == y;
        // value > 0, when x > y;R
    }
}
public class PrimMST {
    static final int V = 8;
    static List<Edge>[] graph = new ArrayList[V];
    static boolean[] visited = new boolean[V];

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        //A to H, 0 to 7
        addEdge(0, 1, 4);  //A-B
        addEdge(0, 7, 6);  //A-H
        addEdge(1, 2, 9);  //B-C
        addEdge(1, 7, 5);  //B-H
        addEdge(1, 4, 2);  //B-E
        addEdge(2, 3, 15); //C-D
        addEdge(3, 4, 15); //D-E
        addEdge(4, 5, 8);  //E-F
        addEdge(5, 6, 3);  //F-G
        addEdge(6, 7, 14); //G-H
        addEdge(7, 5, 10); //H-F

        int totalWeight = prim(0);
        System.out.println("totalWeight = " + totalWeight);

    }

    static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int to = edge.to;
            int weight = edge.weight;

            if (visited[to]) continue;

            visited[to] = true;

            mstWeight += weight;

            for (Edge next : graph[to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        return mstWeight;
    }
}