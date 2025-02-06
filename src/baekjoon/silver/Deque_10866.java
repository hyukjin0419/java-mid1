package baekjoon.silver;

import java.io.*;
import java.util.*;
public class Deque_10866 {
    public static void main(String[] args) throws IOException{
        /*
    push_front X:정수 X를 덱 앞에 넣는다.
    push_back X: 정수 X를 덱 뒤에 넣는다.

    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우 -1을 출력
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우 -1을 출력

    size: 덱에 들어 있는 정수의 개수를 출력
    empty: 덱이 비어있으면 1, 아니면 0을 출력

    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    1. 우선 java 공식문서에 deque기 있는지 확인하고, 있다면 활용한다.
    2. deque는 Interface밖에 없다.
    3.
     */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();

        //반복횟수를 입력받는다.
        int rep = Integer.parseInt(br.readLine());
        //for문
        for(int i=0;i<rep;i++) {
            //명령어 입력을 받는다.
            String input = br.readLine();
            //명령어를 나눈다
            String command[] = input.split(" ");

            //명령어에 따라 위 주석대로 처리한다.
            switch (command[0]){
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    try{
                        System.out.println(deque.removeFirst());
                    }
                    catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    try{
                        System.out.println(deque.removeLast());
                    }
                    catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    try{
                        System.out.println(deque.getFirst());
                    }
                    catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    try{
                        System.out.println(deque.getLast());
                    }
                    catch(Exception e){
                        System.out.println(-1);
                    }
                    break;
            }
        }

    }


}
