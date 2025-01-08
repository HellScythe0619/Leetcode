/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * H-Index = 倒序，max{fun(i) >= i}
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     * 
     * runtime: 70.6% (2 ms)
     * memory: 34.87% (41.7 MB)
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        
        int hIndex = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                hIndex = Math.max(hIndex, citations.length - i);
            }
        }
        
        return hIndex;
    }
}
// @lc code=end
