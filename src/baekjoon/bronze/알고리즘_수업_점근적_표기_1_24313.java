package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 알고리즘_수업_점근적_표기_1_24313 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Integer.parseInt(st.nextToken());
        long a0 = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(br.readLine());
        long n0 = Integer.parseInt(br.readLine());

        long f = a1 * n0 + a0;
        long g = c * n0;
        if(a1 > c) System.out.println(0);
        else if(f <= g) System.out.println(1);
        else System.out.println(0);
    }
}
