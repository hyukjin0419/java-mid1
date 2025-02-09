package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 물음표물음표느낌표_10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuffer sb = new StringBuffer(input);

        sb.append("??!");

        System.out.println(sb.toString());
    }
}
