package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 네_번째_점_3009 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] xs = new int[3];
        int[] ys = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        //x축에 하나
        if(xs[0] == xs[1]) bw.write(xs[2] + " ");
        else if (xs[1] == xs[2]) bw.write(xs[0] + " ");
        else bw.write(xs[1] + " ");


        //y축에 하나
        if(ys[0] == ys[1]) bw.write(ys[2] + " ");
        else if (ys[1] == ys[2]) bw.write(ys[0] + " ");
        else bw.write(ys[1] + " ");

        bw.flush();

    }
}
