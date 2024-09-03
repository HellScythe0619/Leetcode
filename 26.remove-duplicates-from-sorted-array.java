/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    // /**
    //  * 非排序解法
    //  * @param nums
    //  * @return
    //  */
    // public int removeDuplicates(int[] nums) {
    //     int index = 0;
    //     Set<Integer> numSet = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!numSet.contains(nums[i])) {
    //             numSet.add(nums[i]);
    //             nums[index++] = nums[i];
    //         }
    //     }
    //     return index;
    // }

    /**
     * 有排序解法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
// @lc code=end

