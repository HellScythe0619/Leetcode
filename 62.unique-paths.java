/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    /**
     * 假定 最上最左都是1
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] uniquePathArray = new int[m][n];
        for (int i = 0; i < m; i++) {
            uniquePathArray[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            uniquePathArray[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                uniquePathArray[i][j] = uniquePathArray[i - 1][j] + uniquePathArray[i][j - 1];
            }
        }
        return uniquePathArray[m - 1][n - 1];
    }
}
// @lc code=end

