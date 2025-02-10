package baekjoon.bronze;

import java.io.*;

public class 최댓값_2562 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int max_index = 0;

        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > max){
                max = input;
                max_index = i+1;
            }
        }

        bw.write(max + "\n" + max_index);
        bw.flush();
    }
}
