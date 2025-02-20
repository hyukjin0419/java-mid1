import java.util.*;

public class n {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점 개수, 간선 개수, 시작 정점 입력
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();

        // 정점별 값 입력
        int[] values = new int[V + 1]; // 정점 번호는 1부터 시작한다고 가정
        for (int i = 1; i <= V; i++) {
            values[i] = sc.nextInt();
        }

        // 인접 리스트 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        // BFS를 이용한 탐색
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];
        queue.add(start);
        visited[start] = true;

        int sum = 0; // 정점 값들의 합

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sum += values[node];

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(sum);
        sc.close();
    }
}
