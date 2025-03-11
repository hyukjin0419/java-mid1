package baekjoon.algorithm.ds.priorityQueue;

import java.util.Scanner;

public class PriorityQueueUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap heap = new Heap(30);

        while (true) {
            System.out.println("**************** Menu ****************");
            System.out.println("I: Insert a new element into the queue.");
            System.out.println("D: Delete the element with the largest key from the queue.");
            System.out.println("R: Retrieve the element with the largest key.");
            System.out.println("N: Increase the key of an element in the queue.");
            System.out.println("P: Print all elements in the queue.");
            System.out.println("Q: Quit.");

            System.out.print("Choose menu: ");

            String menu = sc.nextLine().toLowerCase();

            switch (menu) {
                case "i":
                    heap.maxHeapInsertion();
                    break;
                case "d":
                    System.out.println("Deleted element: " + heap.maxHeapExtractMax());
                    break;
                case "r":
                    System.out.println("Element with the largest key: " + heap.maxHeapMaximum());
                    break;
                case "n":
                    heap.executeN();
                    break;
                case "p":
                    heap.printHeap();
                    break;
                case "q":
                    System.out.println("Program terminated.");
                    return;
                default:
                    System.out.println("Invalid Input. Please choose a valid command.");
                    break;
            }
        }
    }

}

