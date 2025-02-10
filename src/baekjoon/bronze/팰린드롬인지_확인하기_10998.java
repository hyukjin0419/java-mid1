package baekjoon.bronze;

import java.io.*;

public class 팰린드롬인지_확인하기_10998 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            bw.write(1 + "");
        } else {
            bw.write(0 + "");
        }
        bw.flush();

    }
}
