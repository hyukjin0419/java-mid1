package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class 소인수분해_11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int n = 2;

        while (input > 1) {
            int remainder = input % n;
            if (remainder == 0) {
                input = input / n;
                bw.write(n+"\n");
            } else{
                n++;
            }
        }
        bw.flush();

    }

}
