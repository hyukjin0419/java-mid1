package baekjoon;

import java.util.Scanner;

public class CoutingVowel_1264 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        while(!input.equals("#")){
            int count = 0;
            input = input.toLowerCase();
            char[] chars = input.toCharArray();
            for(int i=0;i<input.length();i++){
                if(isVewel(chars[i])) count ++;
            }
            System.out.println(count);
            input = sc.nextLine();
        }
    }

    private static boolean isVewel(char a){
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        else
            return false;
    }
}
