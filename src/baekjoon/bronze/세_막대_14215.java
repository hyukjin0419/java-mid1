package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 세_막대_14215 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i != maxIndex) sum += arr[i];
        }

        while (max >= sum) {
            max--;
        }

        System.out.println(max+sum);
    }
}
