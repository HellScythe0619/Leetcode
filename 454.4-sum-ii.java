/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    /**
     * O(N^2) -> nums1[] + nums2[] = -(nums3[] + nums4[])
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(-sum, map.getOrDefault(-sum, 0) + 1);
            }
        }
        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
// @lc code=end

