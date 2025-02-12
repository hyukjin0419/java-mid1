package baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 직사각형에서_탈출_1085 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x, y, w, h;
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int widthMinusX = w - x;
        int heightMinuxY = h - y;

        int min = 1000;
        if (widthMinusX < min) {
            min = widthMinusX;
        }
        if (x < min) {
            min = x;
        }
        if (heightMinuxY < min) {
            min = heightMinuxY;
        }
        if (y < min) {
            min = y;
        }

        bw.write(min + "");
        bw.flush();
    }
}
