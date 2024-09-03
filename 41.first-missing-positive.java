/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    /**
     * 透過 swap 將 index i 大多符合 i+1 的形式，
     * 如果數字不為 i+1，代表 i+1 就是答案
     * 題目限制: 
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * 
     * runtime: 100% (1 ms)
     * memory: 82.35% (56.7 MB)
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        int length = nums.length;

        // 使正整數 i 大多符合 index [i-1]
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        // 若當前index [i] 數字不是 i+1，則代表 i+1 是 first missing positive
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

