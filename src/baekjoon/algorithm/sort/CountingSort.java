package baekjoon.algorithm.sort;

public class CountingSort {
    public static void countingSort(int[] A, int k) {
        int n = A.length;
        int[] B = new int[n];     // 결과 배열
        int[] C = new int[k + 1]; // 카운트 배열 (0부터 k까지)

        // 1~2: C 배열 초기화
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        // 3~4: A 배열의 값 개수 세기
        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        // 5~6: 누적 합 계산
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // 7~9: 정렬 결과를 B에 저장 (뒤에서부터 → 안정성 보장)
        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]]-1] = A[j];
            C[A[j]]--;
        }

        // 결과를 A 배열로 복사 (필요에 따라 생략 가능)
        System.arraycopy(B, 0, A, 0, n);
    }

    // 테스트용 메인 메서드
    public static void main(String[] args) {
        int[] A = {2,7,0,2,3,5,3,6,5,5};
        int max = 7; // k: 입력값의 최대값
        countingSort(A, max);

        for (int val : A) {
            System.out.print(val + " ");
        }
    }
}

