package baekjoon.algorithm.ds.priorityQueue;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Heap {
    private Student[] students;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.students = new Student[capacity + 1];
        this.size = 0;
    }

    public void maxHeapInsertion() {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }

        Scanner sc = new Scanner(System.in);
        size++;

        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();

        System.out.print("Enter the score of the element: ");
        int score = getValidScore();

        System.out.print("Enter the class name: ");
        String className = sc.nextLine();

        students[size] = new Student(name, Integer.MIN_VALUE, className);
        heapIncreaseKey(size, score);
        System.out.println("New element [" + name + ", " + score + ", " + className + "] has been inserted.");
    }

    private void heapIncreaseKey(int i, int score) {
        if (score < students[i].getScore()) {
            System.out.println("New score should be larger than current score. Please enter again.");
            return;
        }

        students[i].setScore(score);

        while (i > 1 && students[i / 2].getScore() < students[i].getScore()) {
            Student temp = students[i / 2];
            students[i / 2] = students[i];
            students[i] = temp;
            i = i/2;
        }
    }

    public Student maxHeapExtractMax() {
        if (size < 1) {
            System.out.println("Heap underflow error.");
            return null;
        }

        Student maxStudent = students[1];
        students[1] = students[size];
        students[size] = null;
        size--;
        maxHeapify(1);
        return maxStudent;
    }

    public Student maxHeapMaximum() {
        if (size < 1) {
            System.out.println("Heap is empty.");
            return null;
        }
        return students[1];
    }

    public void maxHeapify(int i) {
        int l = 2 * i;
        int r = 2 * i + 1;

        int largest = i;

        if (l <= size && students[l].getScore() > students[i].getScore()) {
            largest = l;
        }
        if (r <= size && students[r].getScore() > students[largest].getScore()) {
            largest = r;
        }
        if (largest != i) {
            Student temp = students[i];
            students[i] = students[largest];
            students[largest] = temp;
            maxHeapify(largest);
        }
    }

    static int getValidScore() {
        Scanner sc = new Scanner(System.in);
        int score;
        while (true) {
            try {
                score = sc.nextInt();
                sc.nextLine();
                if (score <= 100 && score >= 0) {
                    return score;
                } else {
                    System.out.print("Invalid score. Please enter a valid integer between 0~100: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Wrong Type is entered for score. Please enter a valid integer between 0~100: ");
                sc.nextLine();
            }
        }
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.println(students[i]);
        }
    }

    public void executeN() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the index of the element: ");
        int index = sc.nextInt();
        sc.nextLine();

        int newScore;
        System.out.print("Enter the new score: ");
        newScore = getValidScore();

        while (newScore <= students[index].getScore()) {
            System.out.println("New score should be larger than current score. please enter again.");
            System.out.print("Enter the new score: ");
            newScore = getValidScore();
        }
        System.out.println("Key updated. [" + students[index].getName() + ", " + newScore + ", " + students[index].getCourse() + "] has been repositioned in the queue.");
        heapIncreaseKey(index, newScore);

    }
}
