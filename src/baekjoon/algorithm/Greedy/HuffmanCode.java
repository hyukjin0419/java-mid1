package baekjoon.algorithm.Greedy;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public Node(int freq, Node left, Node right) {
        this.ch = '\0';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.freq - other.freq;
    }
}

public class HuffmanCode {

    public static Node buildHuffmanTree(char[] chars, int[] freqs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++) {
            pq.offer(new Node(chars[i], freqs[i]));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(left.freq + right.freq, left, right);
            pq.offer(newNode);
        }
        return pq.poll();
    }

    public static void printHuffmanCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.ch != '\0') {
            System.out.println(root.ch + " : " + code);
            return;
        }
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F' };
        int[] freqs = { 45, 13, 12, 16, 9, 5 };

        Node root = buildHuffmanTree(chars, freqs);
        printHuffmanCodes(root, "");
    }
}
