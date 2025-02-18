package baekjoon.정렬;

import java.util.*;
import java.io.*;

public class 좌표_압축_18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            set.add(temp);
            arr[i] = temp;
        }

        int[] sortedArr = new int[set.size()];
        int index = 0;
        for (int i : set) {
            sortedArr[index] = i;
            index++;
        }

        Arrays.sort(sortedArr);

        for (int i = 0; i < n; i++) {
            bw.write(Arrays.binarySearch(sortedArr, arr[i])+" ");
        }

        bw.flush();
    }
}
