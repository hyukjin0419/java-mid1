package baekjoon.bronze;

import java.io.*;

public class 문자와_문자열_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int index = Integer.parseInt(br.readLine())-1;

        System.out.println(str.charAt(index));
    }
}
