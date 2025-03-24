package baekjoon.약수_배수와_소수_2;

import java.util.*;
import java.io.*;

public class 가로수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        입력을 받으면서 바로 gcd를 구해서
        Min value update!
        이때 처음과 마지막 수는 저장해놓는다.

        이후 처음에서 minValueGcd만큼 증가하면서 출력한다. end에 도달할 때까지
         */
        int rep = Integer.parseInt(br.readLine());
        long start;
        long n1,n2;
        long end = 0;
        long min = 0;

        start = Integer.parseInt(br.readLine());
        n1 = start;
        for(int i=1;i<rep;i++){
            n2 = Integer.parseInt(br.readLine());
            long gcd = gcd(n1,n2);
            if(gcd < min) min = gcd;

            if(i==rep-1){
                end = n2;
            }

            n1 = n2;
        }

        long result = ((end-start)/min) + 1 -rep;
        System.out.println(result);
    }

    static long gcd(long a,long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
