/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int matchNum = 0;
        for (int i = 0; i <= matchNum; i++) {
            matchNum = Math.max(matchNum, i + nums[i]);
            if (matchNum >= nums.length - 1) {
                return true;
            }
        }
		return false;
    }
}
// @lc code=end

