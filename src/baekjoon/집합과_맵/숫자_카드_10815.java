package baekjoon.집합과_맵;

import java.io.*;
import java.util.*;

public class 숫자_카드_10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (set.contains(temp)) {
                bw.write(1 + " ");
            } else{
                bw. write(0 + " ");
            }
        }

        bw.flush();


    }
}
