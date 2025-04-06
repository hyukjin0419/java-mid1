package baekjoon.algorithm.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] m = matrixChainOrder(p);

        System.out.println("Minimum cost to multiply: " + m[1][p.length - 1]);
    }
    public static int[][] matrixChainOrder(int[] p){
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m;
    }
}
