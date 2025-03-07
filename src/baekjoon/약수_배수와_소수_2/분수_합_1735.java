package baekjoon.약수_배수와_소수_2;

import java.util.*;
import java.io.*;

public class 분수_합_1735 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1,n2,n3,n4;


        StringTokenizer st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n3 = Integer.parseInt(st.nextToken());
        n4 = Integer.parseInt(st.nextToken());

        int denominator, numerator;

        denominator = n2*n4;
        numerator = n1*n4 + n2*n3;

        int divider = getGcd(numerator, denominator);

        denominator = denominator / divider;
        numerator = numerator / divider;

        System.out.println(numerator + " " + denominator);

    }

    static int getGcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
