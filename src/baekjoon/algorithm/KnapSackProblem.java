package baekjoon.algorithm;

import java.util.*;

public class KnapSackProblem {
    static class Item {
        int weight;
        int value;
        double valuePerWeight;

        Item(int weight, int value, double valuePerWeight) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = valuePerWeight;
        }
    }

    public static void main(String[] args) {
        //아이템 10000개 생성
        final int MAX_ITEMS = 10000;
        Item[] allItems = new Item[MAX_ITEMS];
        final long SEED = 100;
        Random rand = new Random(SEED);
        final int[] ITEM_SIZE_FOR_BF = {11, 21, 31};
        final int[] ITEM_SIZE_FOR_OTHER = {10,100,1000,10000};


        for (int i = 0; i < MAX_ITEMS; i++) {
            int weight = rand.nextInt(100) + 1; // 1 ~ 100
            int value = rand.nextInt(500) + 1;  // 1 ~ 500
            double valuePerWeight =(double) value / weight;
            allItems[i] = new Item(weight, value, valuePerWeight);
        }


        System.out.println("Number of Items     Processing time in milliseconds / Maximum benefit value" );
        for (int n : ITEM_SIZE_FOR_BF) {
            Item[] items = Arrays.copyOfRange(allItems, 0, n);
            int capacity = n * 25;
            bruteForce(items, capacity, n);
        }

        System.out.println("Number of Items     Processing time in milliseconds / Maximum benefit value" );
        System.out.println("                    Greedy                D.P.                B. & B.");

        for (int n : ITEM_SIZE_FOR_OTHER) {
            Item[] items = Arrays.copyOfRange(allItems, 0, n);
            Arrays.sort(items, (a,b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));
            int capacity = n * 25;
            System.out.printf("%15d     ", n);
            //greedy
            greedy(items,capacity,n);
////            //dp
            dp(items, capacity, n);
            //bb
            bb(items, capacity, n);
        }
    }

    //AI Generator 사용
    static void bruteForce(Item[] items, int capacity, int n) {
        long startTime = System.currentTimeMillis();

        int maxValue = 0;
        List<Integer> bestCombination = new ArrayList<>();

        long totalComb = 1L << n; //이진수 1을 n번 만큼 leftshift

        for (long mask = 0; mask < totalComb; mask++) {
            int totalWeight = 0;
            int totalValue = 0;
            List<Integer> selected = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1L << i)) != 0) {
                    totalWeight += items[i].weight;
                    totalValue += items[i].value;
                    selected.add(i);
                }
            }

            if (totalWeight <= capacity && totalValue > maxValue) {
                maxValue = totalValue;
                bestCombination = new ArrayList<>(selected);
            }
        }
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;

        System.out.printf("%15d     %27d ms / %d\n", n, processingTime, maxValue);
    }

    static void greedy(Item[] items, int capacity, int n) {
        long startTime = System.currentTimeMillis();

        int weightInTheBag = 0;
        double maxValue = 0;
        int i = 0;

        while (capacity > weightInTheBag) {
            weightInTheBag += items[i].weight;
            maxValue += items[i].value;
            i++;
        }
        int remainedWeight = capacity - weightInTheBag;
        maxValue += remainedWeight * items[i].valuePerWeight;

        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;

        System.out.printf("%3d / %.2f", processingTime, maxValue);
    }

    static void dp(Item[] items, int capacity, int n) {
        //if n == 10000 outofmemory error 발생
        if (n > 1000) return;
        long startTime = System.currentTimeMillis();

        int[][] B = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (items[i - 1].weight <= weight) {
                    if (items[i - 1].value + B[i - 1][weight - items[i - 1].weight] > B[i - 1][weight]) {
                        B[i][weight] = items[i - 1].value + B[i - 1][weight - items[i - 1].weight];
                    } else {
                        B[i][weight] = B[i - 1][weight];
                    }
                } else {
                    B[i][weight] = B[i - 1][weight];
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;

        System.out.printf("%6d / %6d", processingTime, B[n - 1][capacity]);
    }

    static int maxValueOfBB = 0;
    static void bb(Item[] items, int capacity, int n) {
        //if n == 10000 stackoverflow 발생
        if (n > 1000) return;
        long startTime = System.currentTimeMillis();

        dfs(items, capacity, 0, 0, 0,n);

        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;

        System.out.printf("%6d / %6d\n", processingTime, maxValueOfBB);
    }

    static void dfs(Item[] items, int capacity, int index, int benefit, int weight, int n) {
        double bound = calcBound(items, capacity, index, benefit, weight);

        if (weight > capacity || bound <= maxValueOfBB || index >= n) return;
        if (benefit > maxValueOfBB) {
            maxValueOfBB = benefit;
        }

        //왼쪽 자식: 아이템 선택
        dfs(
                items,
                capacity,
                index + 1,
                benefit + items[index].value,
                weight + items[index].weight,
                n
        );

        //오른쪽 자식: 아이템 미선택
        dfs(
                items,
                capacity,
                index + 1,
                benefit,
                weight,
                n
        );
    }

    static double calcBound(Item[] items, int capacity, int index, int benefit, int weight) {
        int weightInTheBag = weight;
        double bound = benefit;
        int i = index;

        while (i < items.length && weightInTheBag + items[i].weight <= capacity) {
            weightInTheBag += items[i].weight;
            bound += items[i].value;
            i++;
        }
        if (i < items.length) {
            int remainedWeight = capacity - weightInTheBag;
            bound += remainedWeight * items[i].valuePerWeight;
        }

        return bound;
    }
}

