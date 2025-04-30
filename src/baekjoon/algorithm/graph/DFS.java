package baekjoon.algorithm.graph;

import java.util.*;

public class DFS {

    enum Color { WHITE, GRAY, BLACK }

    static int time = 0;  // Global time

    public static void DFS(List<List<Integer>> adj, int n) {
        Color[] color = new Color[n];
        int[] d = new int[n];
        int[] f = new int[n];

        for (int u = 0; u < n; u++) {
            color[u] = Color.WHITE;
        }

        time = 0;

        for (int u = 0; u < n; u++) {
            if (color[u] == Color.WHITE) {
                DFSVisit(adj, u, color, d, f);
            }
        }

        // 출력 확인용
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": d = " + d[i] + ", f = " + f[i]);
        }
    }

    private static void DFSVisit(List<List<Integer>> adj, int u, Color[] color, int[] d, int[] f) {
        color[u] = Color.GRAY;
        time++;
        d[u] = time;

        for (int v : adj.get(u)) {
            if (color[v] == Color.WHITE) {
                DFSVisit(adj, v, color, d, f);
            }
        }

        color[u] = Color.BLACK;
        time++;
        f[u] = time;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // 예시: 방향 그래프 (0 → 1 → 2, 0 → 3, 3 → 4 → 5)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(0).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);

        DFS(adj, n);
    }
}

