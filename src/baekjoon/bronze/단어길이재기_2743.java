package baekjoon.bronze;

import java.io.*;
public class 단어길이재기_2743 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        bw.write(input.length() + "");
        bw.flush();
    }
}
