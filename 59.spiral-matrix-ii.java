/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] resultArray = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int count = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                resultArray[top][i] = ++count;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                resultArray[i][right] = ++count;
            }
            right--;

            if (left <= right) {
                for (int i = right; i >= left; i--) {
                    resultArray[bottom][i] = ++count;
                }
                bottom--;
            }
            
            if (top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    resultArray[i][left] = ++count;
                }
                left++;
            }
        }

        return resultArray;
    }
}
// @lc code=end

