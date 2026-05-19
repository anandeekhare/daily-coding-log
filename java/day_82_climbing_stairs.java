public class Day82 {

    static int climb(int n, int[] dp) {

        if (n <= 2)
            return n;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = climb(n - 1, dp) + climb(n - 2, dp);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        System.out.println(climb(n, dp));
    }
}
