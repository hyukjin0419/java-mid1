package baekjoon.bronze;

import java.io.*;

public class 단어공부_1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        String str = br.readLine();
        str = str.toUpperCase();

        for (char c : str.toCharArray()) {
            int a = c - 'A';
            arr[a]++;
        }

        int max = 0;
        int maxIndex = 0;
        boolean isRep = false;
        for (int i=0;i<arr.length;i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
                isRep = false;
            } else if (max == arr[i]) {
                isRep = true;
            }
        }

        if (isRep) {
            bw.write("?");
        } else {
            char result = (char) (maxIndex + 'A');
            bw.write(result);
        }
        bw.flush();

    }

}
