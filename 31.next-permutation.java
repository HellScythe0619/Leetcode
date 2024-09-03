/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    /**
     * runtime: 100%
     * memory: 65.3% (42.9 MB)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 12345->12354->12435->12453->12534->12543->13245->13254->13425->13452...
        int left = nums.length - 2;

        // 找到倒序頭
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left >= 0) {
            int right = nums.length - 1;
            while (nums[left] >= nums[right]) {
                right--;
            }
            swap(nums, left, right);
        }

        reverse(nums, left + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end

