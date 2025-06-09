package baekjoon.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    //이 함수는 pivot을 구하는게 아니고
    //주어진 pivot을 기준으로 나누는 함수임
    public static int partition(int[] A, int p, int r) {
        //r = A.length-1
        //p - 0
        int x = A[r]; //피벗 -> r로 정해짐
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i = i + 1;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 8, 7, 1, 3, 5, 6, 4};

        quickSort(A, 0, A.length - 1);

        System.out.println("A = " + Arrays.toString(A));
    }
}
