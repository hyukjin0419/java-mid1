package baekjoon;

import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        while(input != 0){
            String str = Integer.toString(input);
            String reversedStr = new StringBuilder(str).reverse().toString();
            if(str.equals(reversedStr)){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }
            input = sc.nextInt();
        }
    }
}
