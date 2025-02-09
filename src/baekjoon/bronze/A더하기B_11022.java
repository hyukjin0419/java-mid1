package baekjoon.bronze;

import java.io.*;

public class A더하기B_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());

        for (int i = 1; i <= rep; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            bw.write("Case #" + i + ": " + a + " + " + b + " = " + (a + b) + "\n");
        }
        bw.flush();
    }
}
