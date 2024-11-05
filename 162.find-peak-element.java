/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    /**
     * Use Binary Search
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (0 ms)
     * memory: 72.68% (42.1 MB)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 最後 left 和 right 會重合，任取其一即可
        return left;
    }
}
// @lc code=end

