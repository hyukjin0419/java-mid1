package groomCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 간선이어주기_주석x {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n은 vertex 개수
        //m은 line 개수
        //k는 시작 vertex의 값
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //vertex의 값 입력받기
        int[] values = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        //n+1인 이유가 뭐지?
        //1부터 시작하니까 그렇구나
        //1 부터 n 까지 넣어주고
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        //line 입력 받기
        //여기서 새로 입력받은 간선을 추가해준다.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }//결국 그냥 2차원 graphy가 배열 아닌가 그럼? 아니지, 더 추가할 수 있잖아.
        //그래도 이게 더 직관적이기는 하네.

        //BFS 탐색
        //이후 탐색을 통해 간선을 연결하는 작업을 한다.
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        //이렇게 선언하면 뭐가 달라지나..?
        //Queue자식으로 LinkedList가 생기는데
        //그럼 Queue의 함수를 ovrriding하나?
        //그럼 만약 linkedlist가 다른 부모를 상속받으면
        //linkedlist안에 같은 함수명이라도 다른 동작을 할 수 도 있나?

        boolean[] visited = new boolean[n + 1];
        //지금 나에게 주어진 건 점과 선
        //선은 어디서 시작해서 어디서 끝나는지만 적혀있다.
        //그 상황에 큐를 생성하고
        //visited라는 변수를 생성한다라..->
        //visited의 용도는 간단하다. 내가 점을 방문했는가 하지 않았는가.
        //그럼 큐는 왜 필요한걸까?

        queue.add(k);
        //일단 큐에 지작점을 담는다


        visited[k] = true;
        //그리고 visited 배열을 통해 방문했음 저장한다.

        while (!queue.isEmpty()){
            //큐가 비어있지 않는 동안 반복한다.
            int node = queue.poll();
            //큐에서 정점 번호를 빼서
            sum += values[node - 1];
            //그 번호를 참조하여 value에 담긴 값을 sum에 더한다
            // -1은 왜? values가 0에서 부터 시작하기 때문.

            for (int neighbor : graph[node]) {
                //graph는 뭐고
                //graph[node]는 뭔가?
                //graph는 리스트의 배열. 리스트 인덱스에는 간선의 시작점이
                //리스트 안에는 도착점이 적혀있다.
                //graph[node]는 그래프의 도착점을 의미.
                //첫번째 node는 k임으로 graph[k], 즉 k에서 시작하는
                //모든 간선을 빼서 neighbor안에 차례로 넣는다.
                if(!visited[neighbor]){
                //만약 그 노드를 방문한 적이 없다면
                    visited[neighbor] = true;
                    //해당 노드를 방문했다고 처리한 후
                    queue.add(neighbor);
                    //큐에다가 넣어 그 다음에 따라오는
                    //간선을 확인할 수 있도록 조치한다.
                }
            }
        }

        System.out.println(sum);



//결국엔 O(n^2)이긴 한데,
//시간복잡도는 일단 어떻게 라도 풀 수 있는 다음에 줄여야지
//풀지도 못하는데 줄이는 건 아닌 것 같다.
//물론 지금은 공부단계이니까.


//n = 5
//m = 4
//k = 2
//
// 3, 5, 2, 1, 8
//[1][2][3][4][5]
//    4     5
//    1     3
//
//
//4,5
//4,3
//2,4
//2,1
//
//queue =
//node = 5
//sum += 5 + 3 + 1 + 2 + 8 = 19
//
//graph[4] ->
//[o][o][o][o][o]
//
//result = 19
    }
}
