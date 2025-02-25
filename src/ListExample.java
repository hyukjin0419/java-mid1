import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList 사용
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        System.out.println("ArrayList: " + arrayList);

        // LinkedList 사용
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Elephant");

        System.out.println("LinkedList: " + linkedList);

        // 요소 접근
        System.out.println("첫 번째 요소: " + arrayList.get(0)); // Apple

        // 리스트 순회
        for (String item : arrayList) {
            System.out.println("ArrayList 요소: " + item);
        }
    }
}

