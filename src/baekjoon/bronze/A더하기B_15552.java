package baekjoon.bronze;

import java.io.*;

public class A더하기B_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int n = Integer.parseInt(br.readLine());

        int a,b;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            bw.write(a+b + "\n");
        }
        bw.flush();
    }
}
