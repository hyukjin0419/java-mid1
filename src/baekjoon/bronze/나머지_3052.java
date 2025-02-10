package baekjoon.bronze;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 나머지_3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        int n = 10,i;
        for (i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            int result = input % 42;

            set.add(result);
        }

        System.out.println(set.size());
    }
}
