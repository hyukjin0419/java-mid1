package baekjoon.bronze;

import java.io.*;

public class 킹퀸룩비숍나이트폰_3003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = {1, 1, 2, 2, 2, 8};

        int[] input = new int[answer.length];

        String[] commands = br.readLine().split(" ");

        for (int i=0;i<input.length;i++) {
            input[i] = Integer.parseInt(commands[i]);
        }

        for (int i=0;i<answer.length;i++) {
            bw.write((answer[i] - input[i]) + " ");
        }

        bw.flush();


    }
}
