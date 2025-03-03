package baekjoon.집합과_맵;

import java.util.*;
import java.io.*;

public class 서로_다른_부분_문자열의_개수_11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();

        String str = br.readLine();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                String temp = str.substring(i,j);
                set.add(temp);
            }
        }

        System.out.println(set.size());

    }
}
