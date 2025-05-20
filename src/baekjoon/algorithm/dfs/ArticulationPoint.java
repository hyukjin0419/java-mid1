package baekjoon.algorithm.dfs;

import java.util.*;

public class ArticulationPoint {
    public static void main(String[] args) {
        int n = 7;
        ArticulationPoint finder = new ArticulationPoint(n);

        finder.addEdge(0, 1);
        finder.addEdge(1, 2);
        finder.addEdge(2, 0);
        finder.addEdge(1, 3);
        finder.addEdge(3, 4);
        finder.addEdge(4, 5);
        finder.addEdge(5, 6);
        finder.addEdge(6, 3);

        finder.findArticulationPoints();
    }

    private int time = 0;
    private List<Integer>[] graph;
    private boolean[] visited;
    private int[] d;
    private int[] back;
    private int[] parent;
    private boolean[] isArticulation;

    public ArticulationPoint(int n) {
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n];
        d = new int[n];
        back = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        isArticulation = new boolean[n];
    }

    public void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    public void findArticulationPoints() {
        for (int u = 0; u < graph.length; u++) {
            if (isArticulation[u]) {
                System.out.println("Articulation Point: " + u);
            }
        }
    }

    private void dfs(int u) {
        visited[u] = true;
        d[u] = back[u] = ++time;
        int childCount = 0;

        for (int v : graph[u]) {
            if(!visited[v]) {
                parent[v] = u;
                dfs(v);
                back[u] = Math.min(back[u], back[v]);

                if (parent[u] != -1 && back[v] >= d[u]){
                    isArticulation[u] = true;
                }

                childCount++;
            } else if (v != parent[u]){
                back[u] = Math.min(back[u], d[v]);
            }
        }

        if (parent[u] == -1 && childCount >= 2){
            isArticulation[u] = true;
        }
    }

}
