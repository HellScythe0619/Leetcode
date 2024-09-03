/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming (DP)
     * runtime: 100% (0 ms)
     * memory: 67.12% (41.6 MB)
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        return dpHelper(dp, s1, s2, s3, 0, 0, 0);
    }

    private boolean dpHelper(int[][] dp, String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }

        if (dp[i][j] != 0) {
            return dp[i][j] == 2;
        }

        boolean flag = false;

        if (i == s1.length()) {
            flag = s2.charAt(j) == s3.charAt(k) && dpHelper(dp, s1, s2, s3, i, j + 1, k + 1);
        } else if (j == s2.length()) {
            flag = s1.charAt(i) == s3.charAt(k) && dpHelper(dp, s1, s2, s3, i + 1, j, k + 1);
        } else {
            flag = (s2.charAt(j) == s3.charAt(k) && dpHelper(dp, s1, s2, s3, i, j + 1, k + 1)) ||
                    (s1.charAt(i) == s3.charAt(k) && dpHelper(dp, s1, s2, s3, i + 1, j, k + 1));
        }

        if (flag) {
            dp[i][j] = 2;
        } else {
            dp[i][j] = 1;
        }

        return dp[i][j] == 2;
    }
}
// @lc code=end

