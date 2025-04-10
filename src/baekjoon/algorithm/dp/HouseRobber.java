package baekjoon.algorithm.dp;

public class HouseRobber{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        if (n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i=2;i<n;i++){
            int curr = Math.max(prev1,prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
            System.out.println("curr = " + curr);
        }


        return prev1;
    }


    public static void main(String[] args){
        HouseRobber robber = new HouseRobber();
        int[] nums = {7,6,38,100,30,10,4};
        System.out.println(robber.rob(nums));
    }
}
