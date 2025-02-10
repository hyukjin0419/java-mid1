package baekjoon.silver;

import java.io.*;

public class 그룹_단어_체크_1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rep = Integer.parseInt(br.readLine());
        int count = 0;


        for (int i = 0; i < rep; i++) {
            int[] alphabet = new int[26];
            String str = br.readLine();

            boolean b = true;

            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                alphabet[index] ++;

                if (alphabet[index] >= 2 && j > 0) {
                    for (int k = 0; k < alphabet[index]; k++) {
                        if (str.charAt(j) != str.charAt(j - k)){
                            b = false;
                            break;
                        }
                    }
                }
            }

            if (b) count++;
        }
        bw.write(count+"");
        bw.flush();
    }
}
