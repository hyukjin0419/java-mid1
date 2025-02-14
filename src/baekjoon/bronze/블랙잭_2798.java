package baekjoon.bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙잭_2798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        int num = cards.length;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < num - 2; i++) {
            for (int j = i + 1; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    arr.add(sum);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) > max && arr.get(i) <= m) max = arr.get(i);
        }

        System.out.println(max);


    }
}
