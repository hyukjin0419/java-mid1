package baekjoon.bronze;

import java.io.*;
import java.nio.Buffer;

public class A더하기B_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int a,b;
        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            bw.write("Case #" + i + ": " + (a+b) + "\n");
        }
        bw.flush();
    }
}
