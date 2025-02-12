package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class 약수들의_합_9506 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if(num == -1) break;

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 1; i < num; i++) {
                if(num%i == 0) arr.add(i);
            }

            int total=0;
            for (int i : arr) {
                total += i;
            }

            if (total == num) {
                bw.write(num + " = ");
                for (int i = 0 ; i<arr.size()-1 ; i++) {
                    bw.write(arr.get(i) + " + ");
                }

                bw.write(arr.get(arr.size() - 1) + "");
                bw.write("\n");
            } else {
                bw.write(num + " is NOT perfect.\n");
            }

            bw.flush();

        }
    }
}
