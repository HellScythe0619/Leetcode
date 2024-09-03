/*
 * @lc app=leetcode id=1262 lang=java
 *
 * [1262] Greatest Sum Divisible by Three
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming (DP) O(3) -> O(3N)
     * 整體來說此解法會為 O(K*N) (K:被除數，N:數字長度)
     * runtime: 80.84%
     * memory: 45.21% (46.9 MB)
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        /**
         * 歸納DP有3種可能
         * dp[0]: 餘數為0，整除3(最終解)
         * dp[1]: 餘數為1
         * dp[2]: 餘數為2
         */
        int[] dp = new int[3];

        for (int num : nums) {
            int remainder0 = num + dp[0];
            int remainder1 = num + dp[1];
            int remainder2 = num + dp[2];
            dp[remainder0 % 3] = Math.max(dp[remainder0 % 3], remainder0);
            dp[remainder1 % 3] = Math.max(dp[remainder1 % 3], remainder1);
            dp[remainder2 % 3] = Math.max(dp[remainder2 % 3], remainder2);
        }

        return dp[0];
    }
}
// @lc code=end

