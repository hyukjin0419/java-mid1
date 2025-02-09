package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 코딩은_체육_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        n = n/4;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb.toString());

    }
}
