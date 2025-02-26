package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // 일반 Queue (FIFO)
        Queue<String> queue = new LinkedList<>();
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");

        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll()); // Apple (FIFO 방식)
        System.out.println("Queue after poll: " + queue);

        // PriorityQueue (우선순위 큐, 자동 정렬)
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(20);

        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Poll: " + priorityQueue.poll()); // 10 (가장 작은 값)
    }
}
