package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오븐_시계_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int hour = Integer.parseInt(inputs[0]);
        int min = Integer.parseInt(inputs[1]);

        int addMin = Integer.parseInt(br.readLine());

        min += addMin;

        while(min>=60){
            if (min >= 60) {
                min = min - 60;
                hour++;
            }
        }

        while(hour>=24) {
            if (hour >= 24) {
                hour = hour - 24;
            }
        }

        System.out.println(hour + " " + min);
    }
}
