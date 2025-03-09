package baekjoon.algorithm.sort;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;

    // Constructor: Initialize Heap with a given capacity
    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Get parent, left, and right child indices
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return (2 * i) + 1; }
    private int rightChild(int i) { return (2 * i) + 2; }

    // Heapify: Restore heap property by moving an element down
    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    // Heapify-Up: Restore heap property by moving an element up
    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Insert a new value into the heap
    public void insert(int value) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    // Extract the maximum element (root)
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    // Build Max Heap from an unsorted array
    public void buildMaxHeap(int[] array) {
        heap = Arrays.copyOf(array, array.length);
        size = array.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    // Main method to test the heap
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        // Insert elements into the heap
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(4);

        System.out.println("Heap after insertions:");
        maxHeap.printHeap();

        // Extract max
        System.out.println("Extracted max: " + maxHeap.extractMax());
        maxHeap.printHeap();

        // Build max heap from an array
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        maxHeap.buildMaxHeap(arr);
        System.out.println("Heap after building from array:");
        maxHeap.printHeap();
    }
}
