import java.util.HashMap;
import java.util.HashSet;

public class hashSetMap {
    public static void main(String[] args) {
        // HashSet 사용
        HashSet<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("cherry");

        // HashMap을 HashSet처럼 사용
        HashMap<String, Object> map = new HashMap<>();
        map.put("apple", new Object());
        map.put("banana", new Object());
        map.put("cherry", new Object());

        System.out.println("HashSet: " + set); // [banana, apple, cherry]
        System.out.println("HashMap (Key만): " + map.keySet()); // [banana, apple, cherry]
    }
}
