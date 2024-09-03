/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * Using Arrays.sort()
     * Time Complexity: O(N logN)
     * Space Complexity: O(N)
     * 
     * runtime: 63.36% (6 ms)
     * memory: 40.44% (43.3 MB)
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; ++i) {
            sb.append(strArr[i]);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

}
// @lc code=end

