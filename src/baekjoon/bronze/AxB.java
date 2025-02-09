package baekjoon.bronze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AxB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] inputs = input.split(" ");

        System.out.println(Integer.parseInt(inputs[0]) * Integer.parseInt(inputs[1]));

    }
}
