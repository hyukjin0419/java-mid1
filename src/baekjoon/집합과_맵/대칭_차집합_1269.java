package baekjoon.집합과_맵;

import java.io.*;
import java.util.*;

public class 대칭_차집합_1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> A_B = new HashSet<>(A);
        HashSet<Integer> B_A = new HashSet<>(B);

        A_B.removeAll(B);
        B_A.removeAll(A);

        int count = A_B.size() + B_A.size();


        System.out.println(count);
    }
}
