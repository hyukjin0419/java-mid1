package baekjoon.bronze;

import java.io.*;

public class 다이얼_5622 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int total = 0;
        int[] dial = {
                2,2,2,
                3,3,3,
                4,4,4,
                5,5,5,
                6,6,6,
                7,7,7,7,
                8,8,8,
                9,9,9,9
        };

        for (int i = 0; i < str.length(); i++) {
            //다이얼 계산
            char c = str.charAt(i);
            int n = dial[(c - 'A')];

//            System.out.println(n);


            total += (2+n-1);

        }
        bw.write(total + "");
        bw.flush();
    }
}
