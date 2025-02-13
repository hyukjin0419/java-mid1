package baekjoon.bronze;

import java.io.*;

public class 삼각형_외우기_10101 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int count = 0;

        if(a==b) count++;
        if(b==c) count++;
        if(a==c) count++;

        if((a+b+c) != 180) System.out.println("Error");
        else if(count == 3) System.out.println("Equilateral");
        else if(count == 1) System.out.println("Isosceles");
        else System.out.println("Scalene");
    }
}
