package baekjoon.bronze;

import java.beans.Introspector;
import java.io.*;
import java.util.HashMap;

public class 진법_변환_2_11005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int decimal = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        StringBuilder result = new StringBuilder();

        int remainder;

        HashMap<Integer, Character> converter = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            converter.put(i+10, (char) ('A'+i));
        }


        while (true){
            remainder = decimal%n;
            decimal = decimal/n;

            if (remainder >= 10) {
                result.append(converter.get(remainder));
            } else {
                result.append(remainder);
            }

            if(decimal==0) break;
        }

        bw.write(result.reverse().toString());
        bw.flush();

    }
}
