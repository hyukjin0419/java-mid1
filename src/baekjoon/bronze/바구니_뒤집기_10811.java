package baekjoon.bronze;

import java.io.*;

public class 바구니_뒤집기_10811 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        N개의 바구니, 오름차순으로 정렬된 배열
        M번 진행
        시작, 끝 입력받고 역순으로
         */

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];
        int i,j;
        for (i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        int a,b;
        for (i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0])-1;
            b = Integer.parseInt(inputs[1])-1;


            int c = b-a+1;
            int[] temp = new int[c];

            for (j = 0; j < c; j++) {
                temp[j] = arr[b - j];
            }

            for (j = 0; j < c; j++) {
                arr[a + j] = temp[j];
            }
        }

        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
