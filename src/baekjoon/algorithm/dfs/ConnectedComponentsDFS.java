package baekjoon.algorithm.dfs;

import java.util.*;

public class ConnectedComponentsDFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] label; // 어ㅓ떤 노드가 어떤 components에 속하는지 기록하기 위해.
    static List<List<Integer>> components = new ArrayList<>();

    public static void main(String[] args) {
        int n = 7; //정점수
        int[][] edges = {
                {0,1},{1,2},{3,4},{5,6}
        };

        visited = new boolean[n];
        label = new int[n];

        //그래프 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //무방향 간선 추가
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

//        System.out.println("그래프 인접 리스트 (LinkedList 기반):");
//        for (int i = 0; i < n; i++) {
//            System.out.print(i + " → ");
//            for (int neighbor : graph.get(i)) {
//                System.out.print(neighbor + " ");
//            }
//            System.out.println();
//        }

        int componentId = 0;

        for (int v = 0; v < n; v++) {
            if(!visited[v]){
                components.add(new ArrayList<>());
                dfsVisit(v,componentId);
                componentId++;
            }
        }
        System.out.println("총 연결 요소 수: " + componentId);
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + i + ": " + components.get(i));
        }
    }

    static void dfsVisit(int v, int currentLabel) {
        visited[v] = true;
        label[v] = currentLabel;
        components.get(currentLabel).add(v);

        for (int neighbor : graph.get(v)) {
            if(!visited[neighbor]){
                dfsVisit(neighbor,currentLabel);
            }
        }
    }

}
