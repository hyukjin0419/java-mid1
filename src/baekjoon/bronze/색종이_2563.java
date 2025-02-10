package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class 색종이_2563 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 100, m = 100;

        int[][] arr = new int[n][m];
        int i,j,k,a,b;

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                arr[i][j] = 0;
            }
        }

        int rep = Integer.parseInt(br.readLine());

        for (i = 0; i < rep; i++) {
            String[] inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0])-1;
            b = Integer.parseInt(inputs[1])-1;

            for (j = a; j < 10+a; j++) {
                for (k = b; k < 10 + b; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        int count = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if(arr[i][j] == 1) count++;
            }
        }

        bw.write(count + "");
        bw.flush();
    }
}
