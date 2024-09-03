/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {

    /**
     * Dynamic Programming (DP)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 99.63% (1 ms)
     * memory: 11.48% (57.4 MB)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }
        
        return max;
    }
}
// @lc code=end

