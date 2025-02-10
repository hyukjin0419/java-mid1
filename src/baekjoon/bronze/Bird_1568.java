package baekjoon.bronze;
import java.util.Scanner;

public class Bird_1568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        *
        *  0 ->  1 ->  2 -> 3 -> 4 -> 1 -> 2 -> 1 (sum)
        * 14 -> 13 -> 11 -> 8 -> 4 -> 3 -> 1 -> 0 (num)
        *
        * 0 -> 1 -> 2 (sum)
        * 3 -> 2 -> 0 (num)
        */
        int num = sc.nextInt();
        int sum = 0;
        int count = 0;

        while(num > 0) {
            if (sum >= num) sum = 0;
            sum++;
            num = num - sum;
            count++;
        }

        System.out.println(count);
    }
}
