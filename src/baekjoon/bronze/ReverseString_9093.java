package baekjoon.bronze;

import java.util.Scanner;

public class ReverseString_9093 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<rep;i++){
            String text = sc.nextLine();
            String[] words = text.split("\\s");
            for (String word : words) {
                String reversedWord = new StringBuilder(word).reverse().toString();
                System.out.print(reversedWord + " ");
            }
            System.out.println();
        }
    }
}
