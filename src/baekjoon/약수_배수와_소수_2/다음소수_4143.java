package baekjoon.약수_배수와_소수_2;

import java.io.*;

public class 다음소수_4143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            long n = Long.parseLong(br.readLine());

            while (!isPrime(n)) {
                n++;
            }

            bw.write(n + "\n");
            bw.flush();
        }
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}