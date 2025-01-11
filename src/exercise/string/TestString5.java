package exercise.string;

public class TestString5 {
    public static void main(String[] args) {
        String str = "hello.txt";
        String ext = ".txt";

        int endIndex = str.indexOf(ext);
        String filename = str.substring(0, endIndex);
        String extName = str.substring(endIndex);
        System.out.println("filename = " + filename);
        System.out.println("extName = " + extName);
    }
}
