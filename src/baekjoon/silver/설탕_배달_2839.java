package baekjoon.silver;

import java.io.*;

public class 설탕_배달_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int sum = 0;

        while (num >= 0) {
            if (num % 5 == 0) {
                sum += num / 5;
                System.out.println(sum);
                return;
            } else {
                num -= 3;
                sum ++;
            }
        }
        System.out.println(-1);
    }
}