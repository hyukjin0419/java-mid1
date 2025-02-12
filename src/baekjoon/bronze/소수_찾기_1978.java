package baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 소수_찾기_1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input;
        ArrayList<Integer> arr;
        int result = 0;

        for (int i = 0; i < rep; i++) {
            arr = new ArrayList<>();
            input = Integer.parseInt(st.nextToken());

            if(input == 1) continue;

            for (int j = 1; j < input; j++) {
                int num = input%j;
                if(num == 0) arr.add(j);
            }

            if (arr.size() < 2) {
                result++;
            }
        }
        bw.write(result + "");
        bw.flush();
    }
}
