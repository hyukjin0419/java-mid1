package baekjoon.silver;

import java.io.*;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Editor_1406_Linked_List {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //초기 문자열 입력
        String inputString = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for (char c : inputString.toCharArray()) {
            list.add(c);
        }

        //커서 설정
        ListIterator<Character> iter = list.listIterator(list.size());

        //명령어 처리
        int rep = Integer.parseInt(br.readLine());
        for(int i=0;i<rep;i++){
            String command = br.readLine();
            switch(command.charAt(0)){
                case 'L': //왼쪽으로 커서 이동
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D': //커서 오른쪽으로 이동
                    if(iter.hasNext()) iter.next();
                    break;
                case 'B': //커서 왼쪽의 문자 삭제
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(command.charAt(2));
                    break;
            }
        }

        for (char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
