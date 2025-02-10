package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;


public class 크로아티아_알파벳_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input= br.readLine();

        String[] arr = {
                "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
        };

        for (String str : arr) {
            input = input.replace(str, "*");
        }

        System.out.println(input.length());
    }
}
