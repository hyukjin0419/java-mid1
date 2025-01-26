package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Josephus_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        조셉푸씨의 문제라
        원이라고 생각을 해야한다는 거지?

        1,2,3,4,5,6,7

        linkedlist랑 listiterator쓰자!
         */

        /*
        일단 입력받는다
        n1 -> 이걸로 linkedlist 1~n1까지 생성
        n2 -> 이건 나중에 스텝으로

        linked_list를 통해서만 해보자
        n1을 입력받아서, 해당하는 숫자만큼의 linkedlist를 만든다.
        Linkedlist를 사용한 이유는 간단하다. 중간 값을 없애는데 아주 유용하기 때문이다.
        하지만 문제가 있다. 바로 돌아갈 수 없다는 문제,



         */

        String readedLine = br.readLine();
        String[] nums = readedLine.split(" ");
        int n1 = Integer.parseInt(nums[0]);
        int n2 = Integer.parseInt(nums[1]);

//        System.out.println("n1 = " + n1);
//        System.out.println("n2 = " + n2);

        Queue<Integer> queue= new LinkedList<>();

        for(int i=0;i<n1;i++){
            queue.add(i + 1);
        }

/*queue를 사용하는건 어떤가?
        아 그럼 이러면 어떤가?
        첫번쨰 요소를 빼서 맨 뒤로 넣으면서
        계속해서 첫번째 요소만 검사하는 것이다.

        1: 1,2,3,4,5,6,7 poll & add to same queue
        2: 2,3,4,5,6,7,1 poll & add to same queue
        3: 3,4,5,6,7,1,2 -> poll & add to string builder
        4: 4,5,6,7,1,2
        5: 5,6,7,1,2,4
        6: 6,7,1,2,4,5
 */
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 1;
        int num;
        int addedCount = 0;
        int len = queue.size();

        while(!queue.isEmpty()){
            num = queue.poll();
            if(count % n2 == 0){ //n2 마다
                addedCount++;
                if(addedCount == len){
                    sb.append(num + ">");
                }
                else{
                    sb.append(num + ", ");
                }
            } else{
                queue.add(num);
            }
            count ++;
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
