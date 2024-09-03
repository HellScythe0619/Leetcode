/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * N: the length of String columnTitle
     * 
     * runtime: 86.5% (1 ms)
     * memory: 51.7% (42.1 MB)
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result *= 26;
            int num = c - 'A' + 1;
            result += num;
        }

        return result;
    }
}
// @lc code=end

