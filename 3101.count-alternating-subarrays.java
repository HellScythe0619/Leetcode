/*
 * @lc app=leetcode id=3101 lang=java
 *
 * [3101] Count Alternating Subarrays
 */

// @lc code=start
class Solution {
    /**
     * runtime: 97.32%
     * memory: 64.4% (56.1 MB)
     * @param nums
     * @return
     */
    public long countAlternatingSubarrays(int[] nums) {
        long result = 0;
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                result += (i - count);
            } else {
                count = i;
            }
        }

        // 1 0 1 0
        // 1 0      result = 0 + (1 - 0) = 1
        //   0 1    result = 1 + (2 - 0) = 3
        //     1 0  result = 3 + (3 - 0) = 6
        // result = 6 + 4 = 10

        // 數列中總共錯位的組合 + 數列單獨的組合(N)
        return result + nums.length;
    }
}
// @lc code=end

