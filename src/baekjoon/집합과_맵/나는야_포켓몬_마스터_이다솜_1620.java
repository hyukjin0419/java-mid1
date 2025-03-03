package baekjoon.집합과_맵;

import java.io.*;
import java.util.*;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String> numberToName = new ArrayList<>();
        numberToName.add("");
        Map<String, Integer> nameToNumber = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            numberToName.add(temp);
            nameToNumber.put(temp, i + 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            try {
                int number = Integer.parseInt(temp);
                bw.write(numberToName.get(number) + "\n");
            } catch (NumberFormatException e) {
                bw.write(nameToNumber.get(temp) + "\n");
            }
        }

        bw.flush();

    }
}