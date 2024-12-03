/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 95.95% (2 ms)
     * memory: 92.14% (46.2 MB)
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i % 2 == 0) {
                /**
                 * 當前為偶數，則可以去掉0
                 * ex: 4: 10'0' -> 2: 10
                 */
                dp[i] = dp[i / 2];
            } else {
                /**
                 * 當前為奇數，則比上一個數多一個1
                 * ex: 5: 10'1', 4: 10'0'
                 */
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp;
    }
}
// @lc code=end

