package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Queue_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rep = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rep; i++) {
            String command = br.readLine();
            String[] parts = command.split(" ");
            Integer result;
            switch (parts[0]) {
                case "push":
                    queue.add(Integer.parseInt(parts[1]));
                    break;
                case "pop":
                    if ((result=queue.pollFirst()) == null)
                        System.out.println(-1);
                    else
                        System.out.println(result);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if(!queue.isEmpty())
                        System.out.println(queue.getFirst());
                    else
                        System.out.println(-1);
                    break;
                case "back":
                    if(!queue.isEmpty())
                        System.out.println(queue.getLast());
                    else
                        System.out.println(-1);
                    break;
            }
        }
    }

}
