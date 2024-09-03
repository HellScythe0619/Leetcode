/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     * 
     * runtime: 79% (1 ms)
     * memory: 9.66% (45.8 MB)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        // 判斷第一列是否最後需要全部轉成0
        boolean firstRow = false;
        // 判斷第一行是否最後需要全部轉成0
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }

                    // 標記對應的初始列[i][0]為0
                    matrix[i][0] = 0;
                    // 標記對應的初始行[0][j]為0
                    matrix[0][j] = 0;
                }
            }
        }

        /**
         * 從[1][1]開始判斷，
         * 其對應的初始列[i][0]或初始行[0][j]是否被標記為0，
         * 如果是則轉成0
         */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // 將第一列轉成0
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // 將第一行轉成0
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
// @lc code=end

