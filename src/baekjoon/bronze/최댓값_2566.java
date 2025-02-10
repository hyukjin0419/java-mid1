package baekjoon.bronze;

import java.io.*;

public class 최댓값_2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=9,m=9;
        int[][] arr = new int[9][9];
        int i,j;

        for (i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int max = -1;
        int index1=0,index2=0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if(max < arr[i][j]) {
                    max = arr[i][j];
                    index1 = i+1;
                    index2 = j+1;
                }
            }
        }

        bw.write(max + "\n");
        bw.write(index1 + " " + index2);
        bw.flush();
    }
}
