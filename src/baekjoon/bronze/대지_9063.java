package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 대지_9063 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x, y;

        int rep = Integer.parseInt(br.readLine());

        int maxX = -10000, minX = 10000;
        int maxY = -10000, minY = 10000;

        for (int i = 0; i < rep; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(maxX < x) maxX = x;
            if(minX > x) minX = x;
            if(maxY < y) maxY = y;
            if(minY > y) minY = y;
        }

        int result = (maxX - minX) * (maxY - minY);
        System.out.println(result);
    }
}
