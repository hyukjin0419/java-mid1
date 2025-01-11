package exercise.string;

public class TestString2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int sum = 0;
        for(String word:arr){
            System.out.println(word + ":" + word.length());
            sum += word.length();
        }
        System.out.println("sum = " + sum);
    }
}
