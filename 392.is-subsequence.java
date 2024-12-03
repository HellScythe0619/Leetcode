/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 93.34% (1 ms)
     * memory: 7.07% (41.9 MB)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int index = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(index)) {
                index++;
                if (index == s.length()) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
// @lc code=end

