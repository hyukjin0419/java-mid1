package baekjoon.algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class FragileGlassBallProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(recursive(k,n));
        System.out.println(dp(k,n));
    }

    static int recursive (int k, int n){
        //base code
        if(n <= 1 || k == 1) return n;
        if(k==0) return 0;

        int minAttempts = Integer.MAX_VALUE;

        //try dropping from every height X (1 to N) and take the worst case
        for (int x = 1; x <= n; x++){
            //case1: object breaks. recursive call
            int broken = recursive(k - 1, x - 1);
            //case2: object survives. resursive call
            int intact = recursive(k, n - x);
            int worstCase = 1 + Math.max(broken, intact);

            minAttempts = Math.min(minAttempts, worstCase);
        }
        return minAttempts;
    }

    static int dp(int k, int n){
        //DP Table: dp[i][j] represents minimum attempts for i objects and j meters
        int[][] table = new int[k + 1][n + 1];

        //Fill base cases
        //i -> glass ball
        //j -> heights in meter

        //Fill base cases
        for (int i = 0; i < table.length; i++) {
            Arrays.fill(table[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if(j <= 1 || i == 1) table[i][j] = j;
                if(i==0) table[i][j] = 0;
            }
        }


        //Fill the DP table
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                //.........
                //Try dropping from every height X (1 to j)
                for (int x = 1; x <= j; x++) {
                    //case 1: when object breaks, b = dp[][]
                    int b = table[i-1][x-1];
                    //case 2: when object survivies, s = dp[][]
                    int s = table[i][j-x];

                    int worst = 1 + Math.max(b,s);
                    table[i][j] = Math.min(table[i][j], worst);
                }
            }
        }
        return table[k][n];
    }


}
