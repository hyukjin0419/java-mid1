package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 불교_18108 {
    public static void main(String[] args) throws IOException {
        int n = 2541 - 1998;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(Integer.parseInt(input) - n);

    }
}
