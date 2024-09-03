/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    // public boolean search(int[] nums, int target) {
    //     int low = 0;
    //     int high = nums.length - 1;
    //     if (low == high) {
    //         return nums[low] == target;
    //     }

    //     int orginStartIndex = getOrginStartIndex(nums);
    //     if (nums[low] <= target && target <= nums[orginStartIndex - 1]) {
    //         return binarySearch(nums, low, orginStartIndex - 1, target);
    //     } else if (nums[orginStartIndex] <= target && target <= nums[high]) {
    //         return binarySearch(nums, orginStartIndex, high, target);
    //     }
    //     return false;
    // }

    // private boolean binarySearch(int[] nums, int low, int high, int target) {
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (nums[mid] == target) {
    //             return true;
    //         } else if (nums[mid] < target) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    //     return false;
    // }

    // private int getOrginStartIndex(int[] nums) {
    //     int low = 0;
    //     int high = nums.length - 1;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (nums[mid] > nums[mid + 1]) {
    //             return mid + 1;
    //         } else if (nums[low] >= nums[mid]) {
    //             high = mid;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return 0;
    // }

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 假定 左半段 有 sorted
            else if (nums[low] < nums[mid]) {
                // 確認在 左半段 區間
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // 不在 左半段 區間
                else {
                    low = mid + 1;
                }
            }
            // 假定 右半段 有 sorted
            else if (nums[low] > nums[mid]) {
                // 確認在 右半段 區間
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                // 不在 右半段 區間
                else {
                    high = mid - 1;
                }
            }
            // 有重複片段，起點依序遞增
            else {
                low++;
            }
        }
        return false;
    }
}
// @lc code=end

