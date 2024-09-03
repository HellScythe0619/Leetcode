/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming (DP)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 81.12% (2 ms)
     * memory: 90.67% (44.4 MB)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if nums[i] is Negative
            if (nums[i] < 0) {
                // 使用 swap 把 max 和 min 對調
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);

            result = Math.max(result, currMax);
        }

        return result;
    }
}
// @lc code=end

