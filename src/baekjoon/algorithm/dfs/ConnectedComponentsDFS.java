package baekjoon.algorithm.dfs;

import java.util.*;

public class ConnectedComponentsDFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] label;
    static List<List<Integer>> components = new ArrayList<>();

    public static void main(String[] args) {
        int n = 7; //정점수
        int[][] edges = {
                {0,1},{1,2},{3,4},{5,6}
        };

        visited = new boolean[n];
        label = new int[n];

        //그래프 초기화

    }

}
