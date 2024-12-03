/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 98.14% (2 ms)
     * memory: 75.88% (41.6 MB)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        // 2倍數的乘積
        int i2 = 1;
        // 3倍數的乘積
        int i3 = 1;
        // 5倍數的乘積
        int i5 = 1;

        for (int i = 2; i < dp.length; i++) {
            // dp[i] 即2,3,5倍數值小到大組合
            dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (dp[i] == dp[i2] * 2) {
                i2++;
            }
            if (dp[i] == dp[i3] * 3) {
                i3++;
            }
            if (dp[i] == dp[i5] * 5) {
                i5++;
            }
        }

        return dp[n];
    }
}
// @lc code=end
