package baekjoon.bronze;

import java.util.Scanner;

public class Inference_1731 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        첫번째 요소와 두번째 요소의 차이를 구한다. a
        세번째 요소와 두번째 요소의 차이를 구한다. b
        a와 b가 같으면 등차수열
        a와 b가 다르면 등비수열

        c = a
        등차수열일시 다음 수 = 첫번째 값 + (c)*(index)

        c = arr[1]/arr[0]
        등비수열일시 다음 수 = 첫번째 값 * c^(index)
        * */

        int num = sc.nextInt();
        long[] arr = new long[num];

        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        long a = arr[1] - arr[0];
        long b = arr[2] - arr[1];

        long result = 0;

        if(a==b){
            result = arr[0] + (a * arr.length);
            System.out.println(result);
        } else{
            long c = arr[1]/arr[0];
            result = arr[0] * (int)Math.pow(c,arr.length);
            System.out.println(result);
        }
    }
}
