package baekjoon.algorithm.ds;

import java.io.*;
import java.util.Scanner;

public class PriorityQueue {
    static Scanner sc = new Scanner(System.in);
    static int size = 0;

    public static void main(String[] args) {
        int maxSize = 30;
        Student[] students = new Student[maxSize];
        Student student;


        while (true) {
            String menu = chooseMenu();

            if (menu.equals("i")) {
                maxHeapInsertion(students);
                for (int i = 1; i <= size; i++) {
                    System.out.println(students[i].toString());
                }
            }
//            else if (menu.equals("d")) {
//
//            } else if (menu.equals("r")) {
//
//            } else if (menu.equals("n")) {
//
//            } else if (menu.equals("p")) {
//
//            } else if (menu.equals("q")) {
//
//            } else {
//                continue;
//            }
        }


        //maximum heap size is 30
        //Each element has three fields: name, score, class name
        //index starts from 1

        //--name--//
        //consists only English letters
        //maximum length of 10 characters
        //no need to check the validity of the name -> assuming that the user always enter a vlid name
        //may contains space
        //case sensitive
        //이름은 중복 가능 하지만 점수나 클래스 이름이 달라야 함.

        //--score--//
        //key value
        //scores range 0 ~ 100. Must validate the score and handle invalid inputs appropriately -> 다시 입력?
        //non-numeric characters -> change it to number? or reenter.

        //--class--//
        //may contain spaces
        //case sensitive

        //--menu input option--//
        //case-insensitive


        //여러 문자의 조합이 아닌 한 문자로 커맨드를 실행하는 것이기 때문에,
        //정확해야한다고 생각한다.
    }

    static class Student {
        private String name; //c++로 옮겨야 하기 때문에
        private int score;
        private String course;

        public Student(String name, int score, String course) {
            this.name = name;
            this.score = score;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    ", course='" + course + '\'' +
                    '}';
        }
    }

    static String chooseMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("**************** Menu ****************");
        System.out.println("I: Insert a new element into the queue.");
        System.out.println("D: Delete the element with the largest key from the queue.");
        System.out.println("R: Retrieve the element with the largest key.");
        System.out.println("N: Increase the key of an element in the queue.");
        System.out.println("P: Print ");
        System.out.println("Q: Quit.");

        System.out.print("Choose menu: ");

        return sc.nextLine().toLowerCase();
    }

    static void maxHeapInsertion(Student[] students) {
        size++;
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();
        System.out.print("Enter the score of the element: ");
        int score = sc.nextInt();
        sc.nextLine();
        while (score > 100 || score < 0) {
            System.out.println("Wrong number. Please enter the number 0~100");
            score = sc.nextInt();
            sc.nextLine();
        }
        System.out.print("Enter the class name: ");
        String className = sc.nextLine();

        students[size] = new Student(name, score, className);
        students[size].setScore(Integer.MIN_VALUE);

        heapIncreaseKey(students, size, score);
    }

    static void heapIncreaseKey(Student[] students, int i, int score) {
        if (score < students[i].getScore()) {
            System.out.println("New key is smaller than current key");
        }
        students[i].setScore(score);

        while (i > 1 && students[i / 2].getScore() < students[i].getScore()) {
            int temp = students[i / 2].getScore();
            students[i / 2].setScore(students[i].getScore());
            students[i].setScore(temp);

            i = i/2;
        }
    }
}
