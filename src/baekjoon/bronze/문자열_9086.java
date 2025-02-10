package baekjoon.bronze;

import java.io.*;

public class 문자열_9086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());
        for (int i = 0; i < rep; i++) {
            String str = br.readLine();
            bw.write(str.charAt(0) + "" + str.charAt(str.length() - 1) + "\n");
            bw.flush();
        }
    }
}
