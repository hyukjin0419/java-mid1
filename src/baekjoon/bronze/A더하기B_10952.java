package baekjoon.bronze;

import java.io.*;

public class A더하기B_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a=1,b=1;
        while (true) {
            String[] inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);

            if(a == 0 && b == 0) break;

            bw.write((a + b) + "\n");
        }
        bw.flush();
    }
}
