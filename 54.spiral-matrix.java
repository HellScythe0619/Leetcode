/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return resultList;
        }

        int leftCol = 0;
        int rightCol = matrix[0].length - 1;
        int topRow = 0;
        int bottomRow = matrix.length - 1;

        // 以 spiral 右下左上繞一圈為一個 loop
        while (leftCol <= rightCol && topRow <= bottomRow) {
            for (int i = leftCol; i <= rightCol; i++) {
                resultList.add(matrix[topRow][i]);
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                resultList.add(matrix[i][rightCol]);
            }
            rightCol--;

            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    resultList.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }
            
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    resultList.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }

        return resultList;
    }
}
// @lc code=end

