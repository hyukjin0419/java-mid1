package baekjoon;

import java.util.Scanner;

public class CountWords_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextLine()) {
            String sentence = sc.nextLine().trim();

            if (sentence.isEmpty()) {
                System.out.println(0);
            } else {
                String[] words = sentence.split("\\s+");
                System.out.println(words.length);
            }
        } else{
            System.out.println(0);
        }
    }
}
