package baekjoon.bronze;

import java.io.*;

public class 개수_새기_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] num = new int[rep];

        for (int i = 0; i < rep; i++) {
            num[i] = Integer.parseInt(inputs[i]);
        }

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < rep; i++) {
            if (num[i] == n) {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
    }
}
