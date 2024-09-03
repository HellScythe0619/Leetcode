/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Dynamic Programming 
     * runtime: 85.75%
     * memory: 71.58% (41.8MB)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 空的
        if (numRows == 0) {
            return result;
        }
        
        // 初始第一層
        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
            return result;
        }

        result = generate(numRows - 1);
        // 因為 index 從 0 開始，ex: numRows=1 則 index=0 (numRows和index差1) 
        List<Integer> prevRow = result.get(numRows - 2);
        List<Integer> currentRow = new ArrayList<>();
        // 最左為1
        currentRow.add(1);
        // 除去最左與最右
        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        // 最右為1
        currentRow.add(1);

        result.add(currentRow);
        return result;
    }
}
// @lc code=end

