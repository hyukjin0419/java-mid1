package baekjoon.silver;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Stack_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String command;
        Stack stack = new Stack();
        for(int i=0;i<=count;i++){
            command = sc.nextLine();
            execution(stack,command);
        }
    }

    private static void execution(Stack stack, String str){
        if(str.startsWith("push")){
            String cmd = "push";
            int n = parseInt(str.substring(5));
            stack.push(n);
        } else if (str.equals("pop")){
            System.out.println(stack.pop());
        } else if (str.equals("size")){
            System.out.println(stack.size());
        } else if (str.equals("empty")){
            if (stack.empty() == -1){
                System.out.println(0);
            }
            else{
                System.out.println(stack.empty());
            }
        } else if (str.equals("top")){
            System.out.println(stack.top());
        }
    }

    private static class Stack{
        private ArrayList<Integer> list = new ArrayList<>();
        //push -> list.add()
        public void push(int n){
            list.add(n);
        }
        //pop -> list.remove(마지막 index); index = size-1?
        public int pop(){
            if (list.isEmpty()) return -1;
            return list.remove(list.size()-1);
        }
        //size -> list.size()
        public int size(){
            return list.size();
        }
        //empty -> list.isEmpty();
        public int empty(){
            if (list.isEmpty()) return 1;
            return -1;
        }
        //top -> list.get(마지막 Index);
        public int top(){
            if (list.isEmpty()) return -1;
            return list.get(list.size()-1);
        }
    }
}
