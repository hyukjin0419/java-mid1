package baekjoon.algorithm.dfs;

import java.util.*;

//KosarajuSCC -> 코사라주를 몰라? 너는 진짜 혼나야겠다.
public class StronglyConnectedComponent {
    static int V;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> reversedGraph = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> finishStack = new Stack<>();
    static List<List<Integer>> sccList = new ArrayList<>();

    public static void main(String[] args) {
        V = 8;
        int[][] edges = {
                {1,2}, {2,3}, {3,1},
                {3,4}, {4,5}, {5,6},
                {6,4}, {7,6}, {7,8}
        };

        //인접 리스트 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }

        //간선추가
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            reversedGraph.get(to).add(from);
        }

        System.out.println("순방향 그래프 인접 리스트 (LinkedList 기반):");
        for (int i = 1; i <= V; i++) {
            System.out.print(i + " → ");
            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        System.out.println("역방향 그래프 인접 리스트 (LinkedList 기반):");
        for (int i = 1; i <= V; i++) {
            System.out.print(i + " → ");
            for (int neighbor : reversedGraph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        //Step1: DFS(G) 수행 → 모든 정점 u에 대해 탐생 종료 시간 f[u]를 기록한다.
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs1(i);
        }

        System.out.println("finishStack 구조");
        for (int i = finishStack.size() - 1; i >= 0; i--) {
            System.out.println(finishStack.get(i));
        }
        //Step2: 그래프 G^T 계산 → 즉, 모든 간선의 방향을 뒤집은 그래프를 생선한다.
        visited = new boolean[V + 1];
        while (!finishStack.isEmpty()) {
            int node = finishStack.pop();
            if (!visited[node]) {
                List<Integer> component = new ArrayList<>();
                dfs2(node, component);
                sccList.add(component);
            }
        }

        System.out.println("총 SCC 개수: " + sccList.size());
        for (int i = 0; i < sccList.size(); i++) {
            System.out.println("SCC #" + (i + 1) + ": " + sccList.get(i));
        }
    }

    //DFS(G)
    static void dfs1(int u) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) dfs1(v);
        }
        finishStack.push(u);
    }

    //DFS(G^T)
    static void dfs2(int u, List<Integer> component) {
        visited[u] = true;
        component.add(u);
        for (int v : reversedGraph.get(u)) {
            if(!visited[v]) dfs2(v, component);
        }
    }


}
