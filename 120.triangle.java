/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start

import java.util.List;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 53.15% (4 ms)
     * memory: 39.52% (44.2 MB)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];

        // 從底部開始
        for (int i = height - 1; i >= 0; i--) {
            // 當前層依序紀錄
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == height - 1) {
                    // 最底層直接紀錄當前值
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    // 取當前往下一層最小值的路徑點
                    int cost = Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                    dp[i][j] = triangle.get(i).get(j) + cost;
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end

