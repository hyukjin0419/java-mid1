package baekjoon.bronze;

import java.io.*;

public class 합_8393 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        bw.write(result +"");
        bw.flush();
    }
}
