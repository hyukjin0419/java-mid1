package baekjoon.algorithm.allPairsShortestPaths;

public class TransitiveClosure {
    static final int N = 4;

    public static void main(String[] args) {
        int[][] graph = {
            {1,0,0,0},
            {0,1,1,1},
            {0,1,1,0},
            {1,0,1,1}
        };

        int[][] result = new int[N][N];
        transitiveClosure(graph, result);
        System.out.println("결과");
        printMatrix(result);
    }

    public static void transitiveClosure(int[][] graph, int[][] T) {
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || graph[i][j] == 1) {
                    T[i][j] = 1;
                } else {
                    T[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    T[i][j] = T[i][j] | (T[i][k] & T[k][j]);
                }
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
