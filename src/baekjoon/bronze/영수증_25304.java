package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영수증_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalAmount = Integer.parseInt(br.readLine());

        int rep = Integer.parseInt(br.readLine());
        int[] money = new int[rep];
        int[] num = new int[rep];

        int amount = 0;

        for (int i = 0; i < rep; i++) {
            String[] inputs = br.readLine().split(" ");
            money[i] = Integer.parseInt(inputs[0]);
            num[i] = Integer.parseInt(inputs[1]);

            amount += money[i] * num[i];
        }

        if(amount == totalAmount) System.out.println("Yes");
        else System.out.println("No");
    }
}
