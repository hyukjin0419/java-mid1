package baekjoon.silver;

import java.util.*;
import java.io.*;

public class 숫자_카드_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int count = upperBound(cards, target) - lowerBound(cards, target);
            sb.append(count).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int lowerBound(int[] arr, int value) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] >= value) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public static int upperBound(int[] arr, int value) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] > value) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}


