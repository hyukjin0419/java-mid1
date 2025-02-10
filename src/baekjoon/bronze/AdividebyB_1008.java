package baekjoon.bronze;

import java.util.Scanner;

public class AdividebyB_1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (b!=0){
            double result = (double) a / (double) b;
            System.out.println(result);
        }
    }
}
