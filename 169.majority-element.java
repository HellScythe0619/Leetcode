/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * N: the length of int[] nums
     * 
     * runtime: 99.8% (1 ms)
     * memory: 42.26% (52.9 MB)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }

            if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}
// @lc code=end

