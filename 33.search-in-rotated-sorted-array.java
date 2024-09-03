/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    // public int search(int[] nums, int target) {
    //     int low = 0;
    //     int high = nums.length - 1;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (nums[mid] == target) {
    //             return mid;
    //         }

    //         if (nums[low] <= nums[mid]) {
    //             if (nums[low] <= target && target < nums[mid]) {
    //                 high = mid - 1;
    //             } else {
    //                 low = mid + 1;
    //             }
    //         } else {
    //             if (nums[mid] < target && target <= nums[high]) {
    //                 low = mid + 1;
    //             } else {
    //                 high = mid - 1;
    //             }
    //         }
    //     }
    //     return -1;
    // }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // 假如沒有rotate，一切都順序，則開頭必定小於結尾。
        if (nums[low] <= nums[high]) {
            return binarySearch(nums, low, high, target);
        }
        // 有rotate，則尾數必定小於起始數。
        else {
            // 取得原始起點 rotate 後的 index。
            int orginStartIndex = getOrginStartIndex(nums);
            // 此 target 在 前半段 裡面。
            if (nums[low] <= target && target <= nums[orginStartIndex - 1]) {
                return binarySearch(nums, low, orginStartIndex - 1, target);
            }
            // 此 target 在 後半段 裡面。
            else if (nums[orginStartIndex] <= target && target <= nums[nums.length - 1]) {
                return binarySearch(nums, orginStartIndex, nums.length - 1, target);
            }
            // 都不符合代表都不在這兩段區間，故最終回傳 -1。
        }
        return -1;
    }

    /**
     * 取得 Array 中 rotate起點 (即為 rotate 交會點) O(log N)
     * ex: nums = [4,5,6,1,2,3] -> nums[3] = 1 -> return 3;
     * @param nums
     * @return 
     */
    private int getOrginStartIndex(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // nums[mid] 為最大數，而 nums[mid + 1] 則剛好為原始起點
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            // mid 過頭了，以 high = mid 再搜索
            else if (nums[low] > nums[mid]) {
                high = mid;
            }
            // 還沒過波峰，以 low = mid + 1 再搜索
            else {
                low = mid + 1;
            }
        }
        return 0;
    }

    /**
     * O(log N)
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

