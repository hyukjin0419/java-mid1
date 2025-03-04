package baekjoon.약수_배수와_소수;

import java.io.*;
import java.util.*;

public class 최소공배수_1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*라
        A의 배수이면서
        B의 배수인 수 중 가장 작은 수를 구하여라

         */

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGcd(a, b);
            int lcm = a * b / gcd;
            bw.write(lcm + "\n");
        }

        bw.flush();
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
