package baekjoon.silver;

import java.util.*;
import java.io.*;

public class 수찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력 받아서 첫번째 배열 만들기
        int rep1 = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int[] nums1 = new int[rep1];

        for (int i = 0; i < rep1; i++) {
            nums1[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(nums1);


        //2. 입력 받아서 두번째 배열 만들기
        int rep2 = Integer.parseInt(br.readLine());
        input = br.readLine();
        inputs = input.split(" ");
        int[] nums2 = new int[rep2];

        for (int i = 0; i < rep2; i++) {
            nums2[i] = Integer.parseInt(inputs[i]);
        }

        //3. 두번쨰 배열의 요소 값을 하나씩 돌면서, 첫번째 배열안에서 이진검색 실행하기
        // 찾으면 1 출력
        // 못찾으면 0 출력
        for (int i = 0; i < rep2; i++) {
            int result = binearySearch(nums1, nums2[i], 0, nums1.length - 1);
            if(result == -1) System.out.println(0);
            else System.out.println(1);
        }
    }

    //이진 검색 함수
    //count가 추가되어야 하는데, 어디다 추가 되어야 할까?
    public static int binearySearch(int[] arr, int value, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end)/2;

        if (value > arr[mid]) {
            return binearySearch(arr, value, mid + 1, end);
        } else if (value < arr[mid]) {
            return binearySearch(arr, value, start, mid - 1);
        } else {
            return mid;
        }
    }
}
