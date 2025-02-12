package baekjoon.bronze;

import java.io.*;

public class 중앙_이동_알고리즘_2903 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        0,1,2 ,3 ,4,
//        2,3,5 ,9


//        4,9,25,81

        /*
        이전 + 이전 - 1
        한 변이 2n - 1
         */

        int rep = Integer.parseInt(br.readLine());
        int n = 2;
        for (int i = 0; i < rep; i++) {
            n = 2*n-1;
        }

        int result = n * n;

        bw.write(result + "");
        bw.flush();
    }
}
