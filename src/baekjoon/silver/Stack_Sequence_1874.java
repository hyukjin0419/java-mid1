package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class Stack_Sequence_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        일단 입력 받자
        ArrayList하나 생성한다.

        입력을 받는다. 우선 입력 받은 만큼 수를 넣는다. -> 이때 수는 1부터 오름차순으로 넣는다.
        그 후 입력받은 수를 뺀다.
        두번째 입력을 받는다.
            -> 수가 이전 입력 보다 클 경우 -> 오름차순으로 다시 넣는다 -> 그 후 입력받을 수를 뺀다.
            -> 수가 이전 입력 보다 작은 경우 -> 내림 차순으로 뺀다.
                -> 이 과정에서 이미 없는 숫자를 빼려 하면 NO 출력을 하고 프로그램을 종료한다.

        빼고 넣고르 어떻게 할건지?
            넣기
                -> 일단 들어가는 수는 무조건 증가한다. count라는 변수를 지정해서 ++ 연산만 수행해준다.
            빼기
                -> arraylist에서 pop하는 형식으로 해주어야 한다.
        * */
        int rep = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder result = new StringBuilder();
        int element = 1;
        int previous_num = 0;
        int result_num = 0;

        for(int i=0;i<rep;i++){
            int num = sc.nextInt();

            //수가 이전 입력보다 큰 경우
            if(num > previous_num) {

                for (; element <= num; element++) {
                    stack.add(element);
//                    System.out.println("+");
                    result.append("+\n");
                }
                try{
                    result_num = stack.pop();
                }
                catch (Exception e) {
                    System.out.println("NO");
                    System.exit(0);
                }
//                System.out.println("-");
                result.append("-\n");
            }

            //수가 이전 입력보다 작은 경우
            else{
                while(true){
                    try{
                        result_num = stack.pop();
                    }
                    catch (Exception e) {
                        System.out.println("NO");
                        System.exit(0);
                    }
//                    System.out.println("-");
                    result.append("-\n");
                    if(result_num == num) break;
                }
            }

            previous_num = num;
        }
        System.out.println(result.toString());
    }
}
