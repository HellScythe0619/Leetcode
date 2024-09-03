/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Time Complexity: O(N logN)
     * Space Complexity: O(N)
     * 
     * runtime: 97.2% (7 ms)
     * memory: 36.02% (46.6 MB)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  // O(N logN)
        List<int[]> arrList = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                arrList.add(prev);
                prev = interval;
            }
        }
        arrList.add(prev);

        return arrList.toArray(new int[arrList.size()][]);
    }
}
// @lc code=end

