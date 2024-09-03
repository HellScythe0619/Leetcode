/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    /**
     * Implicit BFS 隱藏版的廣度優先搜索
     * runtime: 61.37% (2 ms)
     * memory: 98.93% (44.4 MB)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int minJumpCount = 0;

        int end = 0;
        int farthest = 0;

        // Implicit BFS
        for (int i = 0; i < nums.length - 1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++minJumpCount;
                break;
            }
            if (i == end) {     // Visited all the items on the current level
                ++minJumpCount; // Increment the level
                end = farthest; // Make the queue size for the next level
            }
        }


        return minJumpCount;
    }
}
// @lc code=end

