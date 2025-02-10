package baekjoon.silver;

import java.io.*;
import java.util.HashMap;

public class 너의_평점은_25206 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //평점 = 과목(학점 * 과목평점)의 합

        HashMap<String,Double> hashMap = new HashMap<>();

        hashMap.put("A+", 4.5);
        hashMap.put("A0", 4.0);
        hashMap.put("B+", 3.5);
        hashMap.put("B0", 3.0);
        hashMap.put("C+", 2.5);
        hashMap.put("C0", 2.0);
        hashMap.put("D+", 1.5);
        hashMap.put("D0", 1.0);
        hashMap.put("F", 0.0);


        Double total = 0.0;
        Double count = 0.0;

        for (int i = 0; i < 20; i++) {
            String[] inputs = br.readLine().split(" ");
            Double score = Double.parseDouble(inputs[1]);
            String grade = inputs[2];

            if(!grade.equals("P")) {
                total += score * hashMap.get(grade);
                count += score;
            }
        }

        Double avg = total / count;

        bw.write(avg + "");
        bw.flush();
    }
}
