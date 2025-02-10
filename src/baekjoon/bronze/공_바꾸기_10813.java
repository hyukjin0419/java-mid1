package baekjoon.bronze;

import java.io.*;

public class 공_바꾸기_10813 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];

        int i;

        for (i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        for (i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]) - 1;
            int b = Integer.parseInt(inputs[1]) - 1;
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for (i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
    }
}
