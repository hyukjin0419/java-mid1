package baekjoon.약수_배수와_소수;

import java.io.*;
import java.util.*;

public class 최소공배수_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            bw.write(lcm(a,b,gcd(a,b)) + "\n");
        }

        bw.flush();

    }

    static int gcd(int a, int b) {
        if(a<b){
            int temp = b;
            b = a;
            a = temp;
        }

        int gcd = 0;

        for (gcd = b; gcd > 0; gcd--) {
            if (a % gcd == 0 && b % gcd == 0) {
                return gcd;
            }
        }

        return -1;
    }

    static int lcm(int a, int b, int g) {
        return a * b / g;
    }
}
