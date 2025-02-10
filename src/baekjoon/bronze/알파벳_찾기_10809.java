package baekjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class 알파벳_찾기_10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (arr[index] == -1) {
                arr[index] = i;
            }
        }

        for (int j : arr) {
            bw.write(j + " ");
        }
        bw.flush();
    }
}
