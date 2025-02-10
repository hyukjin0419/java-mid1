package baekjoon.bronze;

import java.io.*;
public class 행렬덧셈_2738 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        int i,j;

        for (i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (j = 0; j < m; j++) {
                arr2[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                int result = arr1[i][j] + arr2[i][j];
                bw.write(result +" ");
            }
            bw.write("\n");
        }
        bw.flush();


    }
}
