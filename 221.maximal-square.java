/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     * N: the length of row
     * M: the length of col
     * 
     * runtime: 37.71% (9 ms)
     * memory: 13.74% (60.7 MB)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSide = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 當前i,j非初始邊界，判斷 左 和 上 和 對角 的已記錄的dp[][]值，取最小並+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
// @lc code=end

