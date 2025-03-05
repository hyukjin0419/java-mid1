package baekjoon.약수_배수와_소수;

import java.io.*;
import java.util.*;

public class 최소공배수_13241 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        if(b > a){
            long temp = b;
            b = a;
            a = temp;
        }

        long g = gcd(a, b);

        System.out.println(lcm(a,b,g));
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b, long g) {
        return a * b / g;
    }
}
