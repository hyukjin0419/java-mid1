package baekjoon.algorithm.sort;

import java.util.Arrays;

public class IntroSort {
    private static final int SIZE_THRESHOLD = 16;

    public static void sort(int[] arr) {
        int depthLimit = 2 * (int) (Math.log(arr.length) / Math.log(2));
        introsort(arr, 0, arr.length - 1, depthLimit);
    }

    private static void introsort(int[] arr, int low, int high, int depthLimit) {
        int size = high - low + 1;

        if (size < SIZE_THRESHOLD) {
            insertionSort(arr, low, high);
        } else if (depthLimit == 0) {
            heapSort(arr, low, high);
        } else {
            int pivot = partition(arr, low, high);
            introsort(arr, low, pivot - 1, depthLimit - 1);
            introsort(arr, pivot + 1, high, depthLimit - 1);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void heapSort(int[] arr, int low, int high) {
        int size = high - low + 1;

        for (int i = low + size / 2 - 1; i >= low; i--) {
            heapify(arr, size, i, low);
        }

        for (int i = high; i > low; i--) {
            swap(arr, low, i);
            heapify(arr, i - low, low, low);
        }
    }

    private static void heapify(int[] arr, int n, int i, int offset) {
        int largest = i;
        int left = 2 * (i - offset) + 1 + offset;
        int right = 2 * (i - offset) + 2 + offset;

        if (left < offset + n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < offset + n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest, offset);
        }
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 테스트용 main
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 5, 2, 4, 8, 6};
        IntroSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

