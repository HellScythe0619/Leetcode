/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    /**
     * use left and right max height to solve.
     * two-pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1) 
     * 
     * runtime: 100% (0 ms)
     * memory: 12.63% (46.6 MB)
     * 
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int water = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right];
            }
        }

        return water;
    }
}
// @lc code=end

