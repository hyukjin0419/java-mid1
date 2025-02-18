package baekjoon.정렬;

import java.io.*;
import java.util.Arrays;

public class 수_정렬하기_2_2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void mergeSort(int[] arr) {
        if (arr.length > 2) return;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, 0, mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int i=0,j=0,k=0;
        while (left[i] < left.length && right[j] < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (left[i] < left.length) {
            arr[k++] = left[i++];
        }

    }
}
