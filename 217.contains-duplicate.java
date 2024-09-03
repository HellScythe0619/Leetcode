/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * HashSet Solution
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 88.95% (10 ms)
     * memory: 12.09% (60.8 MB)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
// @lc code=end

