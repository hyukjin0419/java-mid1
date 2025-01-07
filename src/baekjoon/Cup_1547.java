package baekjoon;

import java.util.Scanner;

public class Cup_1547 {
    public static void main(String args[]){
/*
* 우선 컵이 3개가 있고
* 그럼 1번 컵에 true를 부여해주자
* 그리고 컵의 위치 교환이 이루어져야 하는데...
* 결국 마지막에 true를 가지고 있는 녀석의 위치를 출력해주면 된다.
*
* 문제는, 그 경우다 true를 가지고 있지 않는 녀석들의 위치교환
*
* 그러면 이건 어떤가? 배열을 2개 만들어서 접근하는 거다.
* 아니다 배열을 하나만 만들어서 해도 괜찮다
* index값이 변하지 않으니까
* 0(이쪽에 있는 녀석이 공의 번호),1,2
* 1,2,3 -> 이렇게 지정한뒤
* 입력된 녀석들을 바꾸자.
*
* 코드짜보자.
*
* 우선 몇번 실행할건지 입력을 받고,
* {1,2,3}배열을 만든다.
* 이후, 실행 횟수 만큼 반복문을 돌린다.
    * 2번의 입력을 받고
    * 입력을 받은 값을 토대로, swith를 한다.
    * 시간복잡도에 대해 생각해야 하는가? -> 요소를 어떻게 찾을 것인가?
        * for문은 또 돌리면 O(n^2)이 되지만, 요소가 정확히 3개이기 때문에 O(n)과 다를바가 없다.
        * 다른 방법은? 정렬후 탐색, HashSet등 이곳에서는 사용할 수 없음.
    * for문을 통해 입력받은 값을 바꾼다.
        * ex) 1과 2가 입력되면
            * 1은 arry[0], 2는 arry[1] -> 이 둘을 temp를 이용해서 바꾼다.
            * 여기서 문제는 arry[0]을 어떻게 구할것인가?
                * equals 나 == 사용해서 요소가 같으면 (정수니까 == 사용) index값을 받아놓고, switch
                * 그럼 index값을 두개 받아놔야 한다.
* */
        Scanner sc = new Scanner(System.in);
        int rep = sc.nextInt();
        int[] arr = {1, 2, 3};

        for(int i=0;i<rep;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if((n1 <= 3 && n2 <= 3) && (n1>=1 && n2>=1)) {
                int i1 = 0, i2 = 0;

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == n1) i1 = j;
                    if (arr[j] == n2) i2 = j;
                }

                int temp = arr[i1];
                arr[i1] = arr[i2];
                arr[i2] = temp;
            }
            else {
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(arr[0]);
    }
}
