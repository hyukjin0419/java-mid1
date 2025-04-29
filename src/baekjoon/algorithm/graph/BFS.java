package baekjoon.algorithm.graph;

import java.util.*;

public class BFS {

    enum Color {
        WHITE, GRAY, BLACK
    }

    public static void bfs(List<List<Integer>> adj, int s) {
        int n = adj.size();

        Color[] color = new Color[n];
        int[] d = new int[n];          // distance
        Integer[] pi = new Integer[n]; // predecessor

        // for each vertex u ∈ V - {s}
        for (int u = 0; u < n; u++) {
            if (u != s) {
                d[u] = Integer.MAX_VALUE;
                pi[u] = null;
                color[u] = Color.WHITE;
            }
        }

        // color[s] = GRAY; d[s] = 0; π[s] = NIL;
        color[s] = Color.GRAY;
        d[s] = 0;
        pi[s] = null;

        // Q = ∅; ENQUEUE(Q, s)
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);

        // while Q ≠ ∅
        while (!Q.isEmpty()) {
            // u = DEQUEUE(Q)
            int u = Q.poll();

            // for each v ∈ Adj[u]
            for (int v : adj.get(u)) {
                // if color[v] = WHITE
                if (color[v] == Color.WHITE) {
                    // then ...
                    color[v] = Color.GRAY;
                    d[v] = d[u] + 1;
                    pi[v] = u;
                    Q.add(v); // ENQUEUE(Q, v)
                }
            }

            // color[u] = BLACK
            color[u] = Color.BLACK;
        }

        // 결과 출력 (선택)
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i +
                    ": distance = " + d[i] +
                    ", parent = " + (pi[i] != null ? pi[i] : "null"));
        }
    }

    // 예제용 main
    public static void main(String[] args) {
        // 정점 0~4
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj.add(new ArrayList<>());

        // 예시 그래프
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        bfs(adj, 0); // 시작 정점 0
    }
}

