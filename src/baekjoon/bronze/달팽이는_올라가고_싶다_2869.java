package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 달팽이는_올라가고_싶다_2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Double day;
        Double up, down;
        Double destinationHeight;

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        up = Double.parseDouble(st.nextToken());
        down = Double.parseDouble(st.nextToken());
        destinationHeight = Double.parseDouble(st.nextToken());

        day = (double) ((destinationHeight - down) / (up - down));

        int result = (int) Math.ceil(day);

        bw.write(result + "");
        bw.flush();
    }
}
