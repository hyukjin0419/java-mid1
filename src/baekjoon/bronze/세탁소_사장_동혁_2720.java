package baekjoon.bronze;

import java.io.*;

public class 세탁소_사장_동혁_2720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        for (int i = 0; i < rep; i++) {
            int input = Integer.parseInt(br.readLine());

            int result = input / quarter;
            bw.write(result + " ");
            input = input % quarter;

            result = input / dime;
            bw.write(result + " ");
            input = input % dime;

            result = input / nickel;
            bw.write(result + " ");
            input = input % nickel;

            result = input / penny;
            bw.write(result + "\n");
            bw.flush();
        }


    }
}
