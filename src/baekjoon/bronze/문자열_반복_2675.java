package baekjoon.bronze;

import java.io.*;

public class 문자열_반복_2675 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());

        for (int i = 0; i < rep; i++) {
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            String str = inputs[1];

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < n; k++) {
                    bw.write(str.charAt(j));
                }
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
