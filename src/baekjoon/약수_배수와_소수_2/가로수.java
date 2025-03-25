package baekjoon.약수_배수와_소수_2;

import java.util.*;
import java.io.*;

public class 가로수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rep = Integer.parseInt(br.readLine());
        int[] trees = new int[rep];

        for (int i = 0; i < rep; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[] gaps = new int[rep - 1];
        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = trees[i + 1] - trees[i];
        }

        int gcdValue = gaps[0];
        for (int i = 1; i < gaps.length; i++) {
            gcdValue = gcd(gcdValue, gaps[i]);
        }

        int result = 0;
        for (int gap : gaps) {
            result += (gap / gcdValue) - 1;
        }

        System.out.println(result);
    }

    static int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
