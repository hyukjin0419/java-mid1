package baekjoon.algorithm.sort;

import java.util.Arrays;

public class RadixSort {
    // A[]: 정렬할 배열, maxDigit: 최대 자리수 (예: 3자리 수면 100의 자리까지)
    public static void radixSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();

        // 1의 자리부터 10, 100, 1000...까지 반복
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(A, exp);
        }
    }

    // 자릿수 기준 Counting Sort
    private static void countingSortByDigit(int[] A, int exp) {
        int n = A.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 0~9 자릿수

        // 해당 자릿수에서 등장 횟수 count
        for (int i = 0; i < n; i++) {
            int digit = (A[i] / exp) % 10;
            count[digit]++;
        }

        // 누적합
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 뒤에서부터 순회하여 안정 정렬
        for (int i = n - 1; i >= 0; i--) {
            int digit = (A[i] / exp) % 10;
            output[count[digit] - 1] = A[i];
            count[digit]--;
        }

        // 원래 배열로 복사
        System.arraycopy(output, 0, A, 0, n);
    }

    // 테스트
    public static void main(String[] args) {
        int[] A = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(A);
        System.out.println(Arrays.toString(A)); // [2, 24, 45, 66, 75, 90, 170, 802]
    }
}
