/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Dynamic Programming
     * runtime: 100%
     * memory: 75.75% (40.8 MB)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            return firstRow;
        }

        List<Integer> prevRow = getRow(rowIndex - 1);
        List<Integer> currentRow = new ArrayList<>();
        // 最左為1
        currentRow.add(1);
        for (int i = 1; i < rowIndex; i++) {
            currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
        }
        // 最右為1
        currentRow.add(1);

        return currentRow;
    }
}
// @lc code=end

