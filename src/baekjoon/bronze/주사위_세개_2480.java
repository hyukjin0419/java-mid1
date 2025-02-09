package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 주사위_세개_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split(" ");
        int a = Integer.parseInt(n[0]);
        int b = Integer.parseInt(n[1]);
        int c = Integer.parseInt(n[2]);

        int count = 0;
        int whichCase = 0;

        if(a==b) {
            count ++;
            whichCase = a;
        }
        if(b==c) {
            count ++;
            whichCase = c;
        }
        if (a == c) {
            count ++;
            whichCase = c;
        }

        int max = 0;
        if(max < a) max = a;
        if(max < b) max = b;
        if(max < c) max = c;

        if (count >= 2) {
            System.out.println(10000+a*1000);
        } else if (count == 1) {
            System.out.println(1000+(whichCase)*100);
        } else{
            System.out.println(max * 100);
        }
    }
}
