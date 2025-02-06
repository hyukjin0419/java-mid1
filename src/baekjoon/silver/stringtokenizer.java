package baekjoon.silver;

import java.util.StringTokenizer;

public class stringtokenizer {

        public static void main(String[] args) {
            String str = "apple orange banana grape cherry";

            // StringTokenizer 실행 속도 측정
            long start1 = System.nanoTime();
            StringTokenizer st = new StringTokenizer(str);
            while (st.hasMoreTokens()) {
                st.nextToken();
            }
            long end1 = System.nanoTime();
            System.out.println("StringTokenizer 실행 시간: " + (end1 - start1) + "ns");

            // split() 실행 속도 측정
            long start2 = System.nanoTime();
            String[] words = str.split(" ");
            long end2 = System.nanoTime();
            System.out.println("split() 실행 시간: " + (end2 - start2) + "ns");
        }


}
