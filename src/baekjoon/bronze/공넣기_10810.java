package baekjoon.bronze;

import java.io.*;

public class 공넣기_10810 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        바구니가 있고
        공이 있다

        N은 바구니의 개수이다.
        바구니는
        1,2,3,4,...,N으로 번호가 매겨져 있다.

        m번 공을 넣는 동작을 실행한다.

        공을 넣을 때 -> 공을 넣을 바구니 범위를 정한다. -> 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다.
        -> 만약 바구니에 공이 들어있으면 새로 공을 넣는다.
        공을 넣을 바구니는 연속되어 있어야 한다.

        1 2

         */


        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] arr = new int[n];

        int start, end, num;

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            start = Integer.parseInt(inputs[0]);
            end = Integer.parseInt(inputs[1]);
            num = Integer.parseInt(inputs[2]);

            for (int j = start-1; j < end; j++) {
                arr[j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();


    }
}
