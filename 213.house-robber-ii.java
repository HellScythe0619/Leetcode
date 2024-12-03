/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    /**
     * https://leetcode.com/problems/house-robber-ii/solutions/5534398/video-divide-an-input-array-into-three-cases/
     * Dynamic Programming
     * 198.house-robber 進階版，house是circle而非array，故頭and尾不可同時取
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * N: the length of int[] nums
     * 
     * runtime: 100% (0 ms)
     * memory: 55.01% (40.9 MB)
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 從 index = 0 到 index = n-1 的最大值
        int max1 = robHelper(nums, 0, nums.length - 1);
        // 從 index = 1 到 index = n 的最大值
        int max2 = robHelper(nums, 1, nums.length);

        return Math.max(max1, max2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int prevRob = 0;
        int maxRob = 0;

        for (int i = start; i < end; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }
}
// @lc code=end
