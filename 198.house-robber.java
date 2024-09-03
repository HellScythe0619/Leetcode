/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming
     * 0ms, runtime: 100%, memory: 68.91% (39.6MB)
     * @param nums
     * @return
     */
    // public int rob(int[] nums) {
    //     if (nums.length == 1) {
    //         return nums[0];
    //     }
    //     int[] resultArray = new int[nums.length];
    //     resultArray[0] = nums[0];
    //     resultArray[1] = Math.max(nums[0], nums[1]);
    //     for (int i = 2; i < nums.length; i++) {
    //         resultArray[i] = Math.max(nums[i] + resultArray[i - 2], resultArray[i - 1]);
    //     }
    //     return resultArray[nums.length - 1];
    // }

    /**
     * Memoization
     * 0ms, runtime: 100%, memory: 42.72% (39.8MB)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            memo[i] = -1;
        }
        return memoFunc(nums, 0, memo);
    }

    private int memoFunc(int[] nums, int index, int[] memo) {
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        memo[index] = Math.max(memoFunc(nums, index + 1, memo), memoFunc(nums, index + 2, memo) + nums[index]);
        return memo[index];
    }
}
// @lc code=end

