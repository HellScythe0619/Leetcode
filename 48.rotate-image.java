/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    /**
     * the STEP to rotate matrix by 90 degree:
     * 1. Transpose the matrix
     * 2. Reverse each row of the matrix
     * 
     * runtime: 100% (0 ms)
     * memory: 33.19% (42.2 MB)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        // Transpose matrix 轉置矩陣
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || i > j) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse row 反轉陣列
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
// @lc code=end

