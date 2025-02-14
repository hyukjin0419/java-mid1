package baekjoon.silver;

import java.io.*;
import java.util.*;

public class 체스판_다시_칠하기_1018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int size = 8;
        char[][] board1 = new char[size][size];
        char[][] board2 = new char[size][size];
        char[][] inputBoard = new char[n][m];
        boolean putW = true;
        int count1= 0,count2=0;
        makeBoard(putW, board1,size);
        int min1 = n*m;
        int min2 = n*m;

        putW = false;
        makeBoard(putW, board2,size);

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                inputBoard[i][j] = input[j];
            }
        }


        for (int i = 0; i <= n-size; i++) {
            for (int j = 0; j <= m-size; j++) {
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        if(inputBoard[i+k][j+l] != board1[k][l]) count1++;
                        if(inputBoard[i+k][j+l] != board2[k][l]) count2++;
                    }
                }
                if(min1 > count1) min1 = count1;
                count1 = 0;
                if(min2 > count2) min2 = count2;
                count2 = 0;
            }
        }

        if(min1 < min2)
            System.out.println(min1);
        else
            System.out.println(min2);
    }

    private static void makeBoard(boolean putW, char[][] board2,int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (putW) {
                    board2[i][j] = 'W';
                } else {
                    board2[i][j] = 'B';
                }
                putW = !putW;
            }
            putW = !putW;
        }
    }
}
