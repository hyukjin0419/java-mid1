package baekjoon.bronze;

import java.io.*;

public class 과제_안낸_닝겐물음표_5596 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 30;
        int[] arr = new int[n];

        for (int i = 0; i <= 27; i++) {
            int input = Integer.parseInt(br.readLine())-1;
            arr[input] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] ==  0) {
                System.out.println(i+1);
            }
        }
    }
}

