public class Day83 {

    static int rob(int[] nums, int index, int[] dp) {

        if (index >= nums.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        // take current house
        int take = nums[index] + rob(nums, index + 2, dp);

        // skip current house
        int skip = rob(nums, index + 1, dp);

        dp[index] = Math.max(take, skip);

        return dp[index];
    }

    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1};

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }

        System.out.println(rob(nums, 0, dp));
    }
}
