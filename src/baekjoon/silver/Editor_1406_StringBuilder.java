package baekjoon.silver;

import java.util.Scanner;

public class Editor_1406_StringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //선언
        StringBuilder str;
        String inputString = sc.nextLine();
        str = new StringBuilder(inputString);

        //논리
        /*
        처음 커서는 String 맨 뒤쪽에 있어야 한다. -> int cursor = input.length()-1;

        입력을 받는다.
        1. L: 커서를 왼쪽으로 옮긴다            -> cursor --;
        2. D: 커서를 오른쪽으로 옮긴다.          -> cursor ++;
        3. B: 커서 왼쪽에 있는 문자를 삭제한다.    -> str.deleteCharAt(cursor - 1);
        4. P $:커서 왼쪽에 '$'를 추가한다.       -> str.insert(cursor, '$');
        * */

        int rep = sc.nextInt();
        sc.nextLine();

        int cursor = inputString.length();
        int strLength = inputString.length();


        for(int i=0;i<rep;i++){

            String command = sc.nextLine();

            if (command.equals("L")){
                if (cursor != 0)
                    cursor--;
            }
            else if (command.equals("D")){
                if (cursor != strLength)
                    cursor++;
            }
            else if (command.equals("B")){
                if(cursor != 0) {
                    str.deleteCharAt(cursor - 1);
                    cursor--;
                    strLength--;
                }
            }
            else if (command.startsWith("P")){
                str.insert(cursor, command.charAt(2));
                cursor++;
                strLength++;

            }
        }



        //결과 출력
        String result = str.toString();
        System.out.println(result);
    }
}
