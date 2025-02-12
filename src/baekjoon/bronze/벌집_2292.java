package baekjoon.bronze;

import java.io.*;

public class 벌집_2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int num = 1;
        int step;
        int count = 0;

        do {
            step = 6 * count;
            num = num + step;
            count++;
        } while (num < input);

        System.out.println(count);
    }
}
