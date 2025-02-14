package baekjoon.bronze;

import java.io.*;

public class 알고리즘_수업_알고리즘의_수행_시간_6 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        long n = Integer.parseInt(br.readLine());

        long result = n*(n-1)*(n-2)/6;

        System.out.println(result);
        System.out.println(3);
    }
}
