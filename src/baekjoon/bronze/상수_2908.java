package baekjoon.bronze;

import java.io.*;

public class 상수_2908 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        StringBuilder sb1 = new StringBuilder(inputs[0]);
        int n1 = Integer.parseInt(sb1.reverse().toString());

        StringBuilder sb2 = new StringBuilder(inputs[1]);
        int n2 = Integer.parseInt(sb2.reverse().toString());

        if (n1 > n2) {
            bw.write(n1 + "");
        } else {
            bw.write(n2 + "");
        }

        bw.flush();
    }
}
