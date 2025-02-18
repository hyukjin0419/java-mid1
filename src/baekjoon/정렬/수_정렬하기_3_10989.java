package baekjoon.정렬;

import java.io.*;

public class 수_정렬하기_3_10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[10001];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            count[input]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                bw.write(i+"\n");
                count[i]--;
            }
        }

        bw.flush();
    }
}
