package exercise.string;

public class TestString10 {
    public static void main(String[] args) {
        String fruits = "apple,banana,mango";
        String [] parts = fruits.split(",");
        for(String fruit: parts){
            System.out.println(fruit);
        }
        String joinedString = String.join("->", parts);
        System.out.println("joinedString = " + joinedString);
    }
}
