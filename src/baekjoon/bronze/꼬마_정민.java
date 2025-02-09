package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 꼬마_정민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        Long a = Long.parseLong(inputs[0]);
        Long b = Long.parseLong(inputs[1]);
        Long c = Long.parseLong(inputs[2]);

        System.out.println(a + b + c);

    }
}
