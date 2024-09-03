/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 最左上起點格子為障礙物
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] uniquePathArray = new int[row][col];
        uniquePathArray[0][0] = 1;
        for (int i = 1; i < row; i++) {
            // 最左排當前格子為障礙物 or 之前有障礙物
            if (obstacleGrid[i][0] == 1 || uniquePathArray[i - 1][0] == 0) {
                uniquePathArray[i][0] = 0;
            } else {
                uniquePathArray[i][0] = 1;
            }
        }
        for (int j = 1; j < col; j++) {
            // 最上排當前格子為障礙物 or 之前有障礙物
            if (obstacleGrid[0][j] == 1 || uniquePathArray[0][j - 1] == 0) {
                uniquePathArray[0][j] = 0;
            } else {
                uniquePathArray[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    uniquePathArray[i][j] = 0;
                } else {
                    uniquePathArray[i][j] = uniquePathArray[i - 1][j] + uniquePathArray[i][j - 1];
                }
            }
        }

        return uniquePathArray[row - 1][col - 1];
    }
}
// @lc code=end

