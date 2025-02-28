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

        //번호 -> 이름 매핑
        List<String> numberToName = new ArrayList<>(n+1);
        numberToName.add("");
        //이름 -> 번호 매핑
        Map<String, Integer> nameToNumber = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            numberToName.add(input);
            nameToNumber.put(input, i);
        }

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            try {
                int temp = Integer.parseInt(input);
                bw.write(numberToName.get(temp) + "\n");
            } catch (NumberFormatException e) {
                bw.write(nameToNumber.get(input)+1 + "\n");
            }
        }

        bw.flush();
    }
}

/*
하나의 배열로 양방향 매핑을 진행하는 게 아니라,
두개의 배열을 생성해 양방향 매핑을 진행하여
시간을 단축시킨다라.
흥미롭다.
 */