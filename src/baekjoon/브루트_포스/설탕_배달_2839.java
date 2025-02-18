package baekjoon.브루트_포스;

import java.io.*;

public class 설탕_배달_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int result = 0;

        while (input >= 1) {
            if (input % 5 == 0) {
                result += input/5;
                break;
            } else{
                input -=3;
                result++;
            }
        }

        if (input < 0) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
}