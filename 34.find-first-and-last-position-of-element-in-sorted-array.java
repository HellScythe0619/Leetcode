/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    /**
     * 使用 recursive divide and conquer
     * runtime: 100%
     * memory: 29.79% (45.9MB)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = searchTarget(nums, 0, nums.length - 1, target, true);
        int end = searchTarget(nums, 0, nums.length - 1, target, false);
        return new int[] { start, end };
    }

    private int searchTarget(int[] nums, int left, int right, int target, boolean isStart) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            if (isStart) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        return searchTarget(nums, left, right, target, isStart);
    }
}
// @lc code=end

