package exercise.string;

public class TestString9 {
    public static void main(String[] args) {
        String email = "hello@example.com";
        String[] strs = email.split("@");

        String idParts = strs[0];
        String emailParts = strs[1];

        System.out.println("ID = " + idParts);
        System.out.println("Domain = " + emailParts);
    }
}
