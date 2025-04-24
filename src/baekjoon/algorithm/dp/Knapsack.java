package baekjoon.algorithm.dp;

public class Knapsack {
    public static int knapsack(int n, int W, int[] w, int[] b){
        int[][] B = new int [n+1][W+1];

        for(int i = 1; i <= n; i++){
            for (int weight = 1; weight <= W; weight++){
                if (w[i] <= weight) {
                    //현재 아이템을 넣을 때 값어치 > 현재 아이템을 넣기 이전의 최대 값어치
                    if (b[i] + B[i - 1][weight - w[i]] > B[i - 1][weight]) {
                        B[i][weight] = b[i] + B[i - 1][weight - w[i]];
                    } else {
                        B[i][weight] = B[i - 1][weight];
                    }
                } else{
                    B[i][weight] = B[i - 1][weight];
                }
            }
        }

        return B[n][W];
    }
}
