/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * runtime: 98.82% (1 ms)
     * memory: 72.56% (44.7 MB)
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int index = 0;

        // 新增比 newInterval[0] 小的 interval array
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            resultList.add(intervals[index]);
            index++;
        }

        // 計算 newInterval 重疊的區域
        int[] temp = new int[] { newInterval[0], newInterval[1] };
        // 此處開始即為 intervals[index][0] < newInterval[0] && intervals[index][1] < newInterval[1]
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            temp[0] = Math.min(temp[0], intervals[index][0]);
            temp[1] = Math.max(temp[1], intervals[index][1]);
            index++;
        }
        resultList.add(temp);

        // 新增比 newInterval[1] 大的 interval array
        while (index < intervals.length) {
            resultList.add(intervals[index]);
            index++;
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
// @lc code=end

