package baekjoon.집합과_맵;

import java.io.*;
import java.util.*;

public class 회사에_있는_사람_7785 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> ppl = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) ppl.add(name);
            else ppl.remove(name);
        }

        List<String> list = new ArrayList<>(ppl);
        list.sort(Collections.reverseOrder());

        for (String name : list) {
            bw.write(name + "\n");
        }

        bw.flush();
    }
}
