package baekjoon.bronze;

import java.io.*;

public class 그대로_출력하기_11718 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            try {
                String str = br.readLine();
                bw.write(str + "\n");
                bw.flush();
            } catch (Exception NullPointerException) {
                System.out.println("????????" +
                        "" +
                        "");
                System.exit(0);
            }
        }
    }
}
