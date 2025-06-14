package baekjoon.algorithm.sssp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class HW6 {
    static class Edge{
        int v,w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int u,d;

        public Node(int u, int d) {
            this.u = u;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }
    }

    static final int INF = Integer.MAX_VALUE/2;
    static final int N = 10;

    public static void main(String[] args) throws IOException {
        int[][] matrix = new int[N][N];
        int[][] resultMatrix = new int[N][N];

        String[] cities = readFileToMatrix(matrix);

        List<List<Edge>> adj = fillAdjList(matrix);

        for (int i = 0; i < N; i++) {
            dijkstra(N,adj,i);
        }

        floyd(matrix,resultMatrix);

        System.out.println("Result of Dijkstra");
        printAdjList(adj, cities);
        System.out.println();
        System.out.println("Result of Floyd");
        printMatrix(resultMatrix, cities);
    }

    static String[] readFileToMatrix(int[][] matrix) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("homework6"));

        String line;

        int i=0,j=0;
        while ((line = br.readLine()) != null) {
            j = 0;
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (word.equals("INF")) {
                    matrix[i][j] = INF;
                    j++;
                    continue;
                }

                try{
                    matrix[i][j] = Integer.parseInt(word);
                    j++;
                } catch (NumberFormatException e){
                    sb.append(word).append(" ");
                }
            }
            i++;
        }
        String[] cities = sb.toString().split(" ");

        return cities;
    }

    static List<List<Edge>> fillAdjList(int[][] matrix) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] != 0 & matrix[i][j] != INF) {
                    adj.get(i).add(new Edge(j, matrix[i][j]));
                }
            }
        }
        return adj;
    }

    static void printMatrix(int[][] matrix, String[] cities) {
        System.out.printf("%-10s","");
        for(String city: cities){
            System.out.printf("%-8s", city);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.printf("%-10s",cities[i]);
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == INF) System.out.printf("%-8s",INF);
                else System.out.printf("%-8s", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void printAdjList(List<List<Edge>> adj, String[] cities) {
        System.out.printf("%-10s","");
        for(String city: cities){
            System.out.printf("%-8s", city);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.printf("%-10s",cities[i]);
            for (Edge edge: adj.get(i)) {
                System.out.printf("%-8s", edge.w);
            }
            System.out.println();
        }
    }

    static void dijkstra(int N, List<List<Edge>> adj, int s) {
        boolean[] visited = new boolean[N];
        int[] d = new int[N];
        PriorityQueue<Node> Q = new PriorityQueue<>();

        Arrays.fill(d, INF);
        d[s] = 0;
        Q.add(new Node(s, 0));

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            int u = cur.u;
            if(visited[u]) continue;
            visited[u] = true;

            for(Edge edge : adj.get(u)) {
                int v = edge.v;
                int w = edge.w;
                relax(u,v,w,d,Q);
            }
        }

        adj.get(s).clear();
        for (int i = 0; i < N; i++) {
            adj.get(s).add(new Edge(i,d[i]));
        }
    }

    static void relax(int u, int v, int w, int[] d, PriorityQueue<Node> Q) {
        if (d[u] != INF && d[v] > d[u] + w) {
            d[v] = d[u] + w;
            Q.add(new Node(v, d[v]));
        }
    }

    static void floyd(int[][] matrix, int[][] result) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (result[i][k] < INF && result[k][j] < INF && result[i][k] + result[k][j] < result[i][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }
    }
}
