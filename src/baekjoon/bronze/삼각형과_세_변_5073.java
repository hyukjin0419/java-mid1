package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 삼각형과_세_변_5073 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] lines = new int[3];
        int max,count, maxIndex;

        while (true) {
            max = 0;
            maxIndex = 0;
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lines.length; i++) {
                lines[i] = Integer.parseInt(st.nextToken());
            }
            if( lines[0]==0 && lines[1]==0 && lines[2]==0) break;

            if(lines[0] == lines[1]) count++;
            if(lines[1] == lines[2]) count++;
            if(lines[0] == lines[2]) count++;

            for (int i = 0; i < lines.length; i++) {
                if(lines[i] > max){
                    max = lines[i];
                    maxIndex = i;
                }
            }

            int sum=0;
            for (int i = 0; i < lines.length; i++) {
                if(i != maxIndex){
                    sum += lines[i];
                }
            }

            if(count == 3){
                System.out.println("Equilateral");
            } else if (sum <= max) {
                System.out.println("Invalid");
            } else if (count == 1) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
