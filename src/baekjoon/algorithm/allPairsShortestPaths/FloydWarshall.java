package baekjoon.algorithm.allPairsShortestPaths;

import java.util.*;

public class FloydWarshall {
    static final int INF = Integer.MAX_VALUE / 2; //overflow 방지
    static final int N = 5;

    public static void main(String[] args) {

        int[][] weight = {
                {0, 3, 8, INF, -4},
                {INF, 0, INF, 1, 7},
                {INF, 4, 0, INF, INF},
                {2, INF, -5, 0, INF},
                {INF, INF, INF, 6, 0}
        };

        int[][] dist = new int[N][N];
        int[][] pred = new int[N][N];

        floyd(weight,dist,pred);
        printMatrix(dist);
        System.out.println();
        printPreMatrix(pred);

    }

    public static void floyd(int[][] w, int[][] d, int[][] pred) {
        int n = w.length;

        //초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = w[i][j];
                if(i==j || w[i][j] == INF) {
                    pred[i][j] = -1; //nil
                } else {
                    pred[i][j] = i+1;
                }
            }
        }

        //점화식
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][k] < INF && d[k][j] < INF &&
                            /*
                            실제 경로가 있는지 보겠다는거
                            만약 d[i][k] == INF면 실제 경로가 없다는 것.
                            하지만 이때 d[i][j] + d[k][j]를 더하면
                            무한대가 되는게 아니라 overflow가 발생함!
                            */
                            d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        pred[i][j] = pred[k][j];
                    }
                }
            }
        }
    }

    public static void printPath(int i, int j, int[][] pred) {
        if (i == j) {
            System.out.println(i + 1);
        } else if (pred[i][j] == -1) {
            System.out.println("경로 없음");
        } else {
            printPath(i, pred[i][j], pred);
            System.out.println(" -> " + (j + 1));
        }
    }

    public static void printMatrix(int[][] mat) {
        System.out.println("DP Table 출력");
        for (int[] row : mat) {
            for (int val : row) {
                if(val == INF) System.out.print("INF\t");
                else System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void printPreMatrix(int[][] mat) {
        System.out.println("Predecessor Table 출력");
        for (int[] row : mat) {
            for (int val : row) {
                if(val == -1 || val == INF) System.out.print("NIL\t");
                else System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}

