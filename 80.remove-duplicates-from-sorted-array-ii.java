/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    /**
     * runtime: 100% (0 ms)
     * memory: 77.7% (44.3 MB)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            /**
             * Example: [1,1,1,2,2,3]
             * i = 2, j = 2
             *      nums[2] == nums[0]
             * [1,1,1,2,2,3]
             * i = 3, j = 2
             *      nums[3] != nums[0] -> nums[2] = nums[3], j++
             * [1,1,2,2,2,3]
             * i = 4, j = 3
             *      nums[4] != nums[1] -> nums[3] = nums[4], j++
             * [1,1,2,2,2,3]
             * i = 4, j = 3
             * [1,1,2,2,3,3]
             */
            // System.out.println("i: " + i + ", j: " + j + ", nums[" + i + "]: " + nums[i] + ", nums[" + (j - 2) + "]"
            //         + nums[j - 2] + ", nums[i] != nums[j - 2]: " + (nums[i] != nums[j - 2]));
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
            // StringBuilder sb = new StringBuilder();
            // sb.append("[ ");
            // for (int num : nums) {
            //     sb.append(num).append(", ");
            // }
            // sb.deleteCharAt(sb.length() - 2);
            // sb.append("]");
            // System.out.println(sb);
        }
        
        return j;
    }
}
// @lc code=end

