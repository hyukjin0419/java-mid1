package baekjoon.정렬;

import java.io.*;
import java.util.StringTokenizer;

public class 좌표_정렬하기_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
            points[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
        }

        mergeSort(points, 0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(points[i][0] + " " + points[i][1] + "\n");
        }

        bw.flush();
    }

    static void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[][] arr, int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i][0] < arr[j][0] || arr[i][0] == arr[j][0] && arr[i][1] <= arr[j][1]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid) temp[k++] = arr[i++];
        while(j<=right) temp[k++] = arr[j++];

        System.arraycopy(temp,0,arr,left, temp.length);

    }
}
