/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    /**
     * create new minPathArray
     * @param grid
     * @return
     */
    // public int minPathSum(int[][] grid) {
    //     if (grid == null) {
    //         return 0;
    //     }

    //     int rowLength = grid.length;
    //     int colLength = grid[0].length;
    //     int[][] minPathArray = new int[rowLength][colLength];
    //     minPathArray[0][0] = grid[0][0];
    //     for (int i = 1; i < rowLength; i++) {
    //         minPathArray[i][0] = minPathArray[i - 1][0] + grid[i][0];
    //     }
    //     for (int j = 1; j < colLength; j++) {
    //         minPathArray[0][j] = minPathArray[0][j - 1] + grid[0][j];
    //     }

    //     for (int i = 1; i < rowLength; i++) {
    //         for (int j = 1; j < colLength; j++) {
    //             int upSum = grid[i][j] + minPathArray[i - 1][j];
    //             int leftSum = grid[i][j] + minPathArray[i][j - 1];
    //             minPathArray[i][j] = Math.min(upSum, leftSum);
    //         }
    //     }

    //     return minPathArray[rowLength - 1][colLength - 1];
    // }

    /**
     * trans gridArray
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 1; i < rowLength; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < colLength; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rowLength - 1][colLength - 1];
    }
}
// @lc code=end

