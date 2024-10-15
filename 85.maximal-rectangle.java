/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * Time Complexity: O(N * M)
     * Space Complexity: O(N * M)
     * N: the number of rows
     * M: the number of columns
     * 
     * runtime: 8.5% (31 ms)
     * memory: 79.52% (45.5 MB)
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // 紀錄當前列 row，每行 col 的 height[i]
            for (int j = 0; j < cols; j++) {
                /**
                 * 當前為字元為'1'，則當前行 col 的 height[i] + 1，此 height[] 會適用到每個 row
                 * 否則字元為'0'，則視為斷掉，將 height[i] 變為 0
                 */
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            
            // 初始化
            int[] nextSmaller = new int[cols];
            for (int j = 0; j < cols; j++) {
                nextSmaller[j] = cols;
            }
            // 初始化
            int[] prevSmaller = new int[cols];
            for (int j = 0; j < cols; j++) {
                prevSmaller[j] = -1;
            }

            Stack<Integer> stack = new Stack<>();
            // 尋找當前的下一個最小數
            for (int j = cols - 1; j >= 0; j--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    nextSmaller[j] = stack.peek();
                }
                stack.push(j);
            }

            stack.clear();
            // 尋找當前的前一個最小數
            for (int j = 0; j < cols; j++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    prevSmaller[j] = stack.peek();
                }
                stack.push(j);
            }

            // 計算每行的 maxArea
            for (int j = 0; j < cols; j++) {
                int width = nextSmaller[j] - prevSmaller[j] - 1;
                int area = heights[j] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
// @lc code=end

