package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class 배수와_약수_5086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0, b = 0;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0) break;

            //약수 테스트
            if (b % a == 0) {
                bw.write("factor\n");
            }
            //배수 테스트
            else if (a % b == 0) {
                bw.write("multiple\n");
            } else {
                bw.write("neither\n");
            }
        }

        bw.flush();

    }
}
