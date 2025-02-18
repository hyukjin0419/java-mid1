package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class 나이순_정렬_10814_내장함수_사용 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Object[][] arr = new Object[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (a,b)->{
            return Integer.compare((int) a[0], (int) b[0]);
        });


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][0] + " ");
            System.out.println(arr[i][1]);
        }

    }
}
