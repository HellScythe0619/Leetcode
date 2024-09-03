/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * Multi Source BFS O(m*n)
     * runtime: 80.37%
     * memory: 59.37% (47.2 MB)
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    // 符合0的作為Source，放入Queue進行BFS
                    queue.add(new int[] { i, j });
                } else {
                    // 將不為0的標示最大值，以待處理。
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            for (int[] direction : directions) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];

                if (row >= 0 && row < mat.length &&
                    col >= 0 && col < mat[0].length &&
                    // 覆寫由其他source BFS給的過大數值，替換成小數值
                    mat[cell[0]][cell[1]] + 1 < mat[row][col]) {
                    
                    queue.add(new int[] { row, col });
                    mat[row][col] = mat[cell[0]][cell[1]] + 1;
                }
            }
        }

        return mat;
    }
}
// @lc code=end

