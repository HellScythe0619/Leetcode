/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming (DP)
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     * 
     * runtime: 100% (0 ms)
     * memory: 80.23% (39.9 MB)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        /**
         * dp[2]:
         *  dp[0] * dp[1] + 
         *  dp[1] * dp[0]
         * dp[3]:
         *  dp[0] * dp[2] +
         *  dp[1] * dp[1] +
         *  dp[2] * dp[0]
         */

        return dp[n];
    }
}
// @lc code=end

