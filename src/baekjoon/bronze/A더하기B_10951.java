package baekjoon.bronze;

import java.io.*;

public class A더하기B_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a=1,b=1;
        try {
            while (true) {
                String[] inputs = br.readLine().split(" ");
                a = Integer.parseInt(inputs[0]);
                b = Integer.parseInt(inputs[1]);


                bw.write((a + b) + "\n");

            }
        } catch (Exception e) {
            bw.flush();
        }
    }
}
