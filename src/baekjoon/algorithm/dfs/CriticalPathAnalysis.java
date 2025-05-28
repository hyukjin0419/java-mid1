package baekjoon.algorithm.dfs;

import java.util.*;

public class CriticalPathAnalysis {
    static class Task {
        int id;
        int duration;
        List<Integer> predecessors = new ArrayList<>();

        public Task(int id, int duration) {
            this.id = id;
            this.duration = duration;
        }
    }

    static Map<Integer, Task> tasks = new HashMap<>();
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Integer> longestDuration = new HashMap<>();
    static List<Integer> criticalPath = new ArrayList<>();

    public static void addTask(int id, int duration) {
        tasks.put(id, new Task(id, duration));
        graph.putIfAbsent(id, new ArrayList<>());
    }

    public static void addEdge(int from, int to) {
        graph.get(from).add(to);
        tasks.get(to).predecessors.add(from);
    }

    public static void dfs(int node, List<Integer> path, int currentSum) {
        path.add(node);
        currentSum += tasks.get(node).duration;

        if (!graph.containsKey(node) || graph.get(node).isEmpty()) {
            if (currentSum > longestDuration.getOrDefault(-1, 0)) {
                longestDuration.put(-1, currentSum);
                criticalPath = new ArrayList<>(path);
            }
        } else {
            for (int next : graph.get(node)) {
                dfs(next, path, currentSum);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        //작업 추가
        addTask(1, 3);
        addTask(2, 2);
        addTask(3, 1);
        addTask(4, 4);
        addTask(5, 2);
        addTask(-1, 0);

        //선행 관계 추가
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,4);
        addEdge(3,4);
        addEdge(4,5);
        addEdge(5,-1);

        //시작점 찾기 (선행자가 없는 노드)
        Set<Integer> startingTasks = new HashSet<>(tasks.keySet());
        for (Task t : tasks.values()) {
            startingTasks.removeAll(t.predecessors);
        }

        for (int start : startingTasks) {
            if (start == -1) continue;
            dfs(start, new ArrayList<>(), 0);
        }

        System.out.println("criticalPath = " + criticalPath);
        System.out.println("Total Duration: " + longestDuration.get(-1));

    }
}
