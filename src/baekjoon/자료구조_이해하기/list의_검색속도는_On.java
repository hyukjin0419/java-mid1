package baekjoon.자료구조_이해하기;

import java.util.*;

public class list의_검색속도는_On {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        int index = list.indexOf("A");
        System.out.println("A의 인덱스 " + index);
    }

    //코드 실행을 위해 변수 초기화
    int size=0;
    int []elementData;

    //index의 내부적 작동 수도 코드
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    //즉 list의 검색 시간 복잡도는 O(N)
}
