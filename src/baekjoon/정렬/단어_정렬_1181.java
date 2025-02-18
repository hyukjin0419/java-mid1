package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class 단어_정렬_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });

        Set<String> set = new LinkedHashSet<>(list);
        list = new LinkedList<>(set);

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i)+"\n");
        }

        bw.flush();
    }

}
