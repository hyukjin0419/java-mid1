package baekjoon.집합과_맵;

import java.util.*;
import java.io.*;

public class 숫자_카드_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(temp, new ArrayList<>()).size();
            bw.write(count + " ");
        }

        bw.flush();


    }
}
