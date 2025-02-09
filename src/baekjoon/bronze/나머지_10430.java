package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나머지_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");
        int[] n = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            n[i] = Integer.parseInt(inputs[i]);
        }


        System.out.println((n[0] + n[1])%n[2]);
        System.out.println(((n[0]%n[2])+(n[1]%n[2]))%n[2]);
        System.out.println((n[0] * n[1])%n[2]);
        System.out.println(((n[0]%n[2])*(n[1]%n[2]))%n[2]);
    }
}
