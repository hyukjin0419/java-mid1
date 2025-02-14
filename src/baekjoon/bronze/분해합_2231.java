package baekjoon.bronze;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class 분해합_2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        ArrayList<Long> arr = new ArrayList<>();

        for (long i = 0; i < n; i++) {
            long sumOfDigits = getDecimal(i);
            if ((sumOfDigits + i) == n) {
                arr.add(i);
            }
        }
        if(!arr.isEmpty())
            System.out.println(arr.get(0));
        else
            System.out.println(0);
    }

    public static long getDecimal(long input) {
        long divider = 1000000;
        long result = 0;
        while (divider >= 1) {
            if(input / divider !=0) {
                result += input / divider;
                input = input%divider;
            }
            divider = divider/10;
        }
        return result;
    }
}
