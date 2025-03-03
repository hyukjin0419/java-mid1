package baekjoon.집합과_맵;

import java.util.*;
import java.io.*;

public class 듣보잡_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            map.computeIfAbsent(temp, key -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            map.computeIfAbsent(temp, key -> new ArrayList<>()).add(i);
        }

        List<String> result = new ArrayList<>();
        map.forEach((key,value) -> {
            if(value.size()>=2){
                result.add(key);
            }
        });

        Collections.sort(result);

        bw.write(result.size() + "\n");
        for (String str : result) {
            bw.write(str + "\n");
        }

        bw.flush();
    }
}
