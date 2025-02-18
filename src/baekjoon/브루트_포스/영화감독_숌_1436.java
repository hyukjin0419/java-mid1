package baekjoon.브루트_포스;

import java.io.*;

public class 영화감독_숌_1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long count = 0;

        long input = Integer.parseInt(br.readLine());

        int number = 0;

        while (input != count) {
            number ++;
            if (find666(number)) {
                count++;
            }
        }
        System.out.println(number);
    }

    private static boolean find666(int num) {
        int count = 0;
        int divider = 10;

        do {
            int temp = num % divider;
            if (temp == 6) {
                count++;
            } else {
                count = 0;
            }

            if (count == 3) return true;

            num = num / divider;
        } while (num>=1);

        return false;
    }
}
