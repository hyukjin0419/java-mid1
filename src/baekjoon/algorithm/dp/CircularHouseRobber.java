package baekjoon.algorithm.dp;

public class CircularHouseRobber {
    public int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0, curr = 0;

        for (int i = start; i <= end; i++) {
            curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n==0) return 0;
        if (n==1) return nums[0];

        return Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1)
        );
    }

    public static void main(String[] args) {
        CircularHouseRobber robber = new CircularHouseRobber();
        int[] nums = {7,6,38,100,30,10,4};
        System.out.println(robber.rob(nums));
    }
}
