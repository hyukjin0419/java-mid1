package baekjoon;

import java.util.Scanner;

public class MostUsedChar_1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] countChar = new int[26];
        int max = 0;
        StringBuilder result = new StringBuilder();
        String input = "";

        while (sc.hasNextLine()) {
            input = sc.nextLine().trim();
            input = input.replaceAll("\\s","");
            char[] chars = input.toCharArray();
            int charsToInt = 0;

            for (int i = 0; i < input.length(); i++) {
                charsToInt = chars[i] - 'a';
                countChar[charsToInt]++;
            }
        }

        for (int i = 0; i < countChar.length; i++) {
            if (countChar[i] > max) {
                max = countChar[i];
                result.setLength(0);
                result.append((char) (i + 'a'));
                2
            } else if (countChar[i] == max) {
                result.append((char) (i + 'a'));
            }
        }
        String resultSentence = result.toString();
        System.out.println(resultSentence);
    }
}
