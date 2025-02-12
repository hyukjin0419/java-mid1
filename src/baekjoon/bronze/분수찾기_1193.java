package baekjoon.bronze;

import java.io.*;

public class 분수찾기_1193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int mom, son;
        int num = Integer.parseInt(br.readLine());

        do{
            num -= count;
            count++;
        } while(count < num);
        num--;

        //odd
        if (count % 2 != 0) {
            son = count - num;
            mom = 1 + num;
        }
        //even
        else {
            son = 1 + num;
            mom = count - num;
        }

        bw.write(son + "/" +mom);
        bw.flush();
    }
}
