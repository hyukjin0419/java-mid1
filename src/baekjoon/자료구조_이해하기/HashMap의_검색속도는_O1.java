package baekjoon.자료구조_이해하기;

import java.util.HashMap;

public class HashMap의_검색속도는_O1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        int number = map.get("A");
        System.out.println("A의 번호: " + number);
    }

    //HaspMap의 검색 동작 방식
    //1. 해시 함수를 이용해 key를 특정 인덱스로 변환
//    int hash = key.hashCode();
    //2. 해시의 배열의 인덱스로 변환(mod 연산)
//    int index = hash % capacity;
    // 3. 배열의 해당 인덱스에 접근하여 값을 반환 O(1)
//    return table[index].value;
}

