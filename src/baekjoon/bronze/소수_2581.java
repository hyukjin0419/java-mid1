package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class 소수_2581 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lowBound = Integer.parseInt(br.readLine());
        int upperBound = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;

        for (int i = lowBound; i <= upperBound; i++) {
            count = 0;

            if(i==1) continue;

            for (int j = 1; j < i; j++) {
                if (i % j == 0) count++;
            }
            if(count < 2) arr.add(i);
        }

        if(arr.isEmpty()){
            bw.write(-1+"");
            bw.flush();
            System.exit(-1);
        }
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }


        bw.write(sum +"\n");
        bw.write(arr.get(0) + "");

        bw.flush();

    }
}
