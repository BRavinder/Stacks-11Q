class Solution {
    public int numWays(int steps, int arrLen) {
        if (steps < 1 || arrLen < 1) return 0;
        int mod = (int) 1e9 + 7;
        int[] dp = new int[arrLen];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dp2 = new int[arrLen];
            for (int j = 0; j < Math.min(i + 1, arrLen); j++) {
                dp2[j] = (dp[j] + (j > 0 ? dp[j - 1] : 0)) % mod;
                dp2[j] = (dp2[j] + (j < arrLen - 1 ? dp[j + 1] : 0)) % mod;
                if (i == steps) break;
            }
            dp = dp2;
        }
        return dp[0];
    }
}
// T : O(n)
// Sp : O(1)