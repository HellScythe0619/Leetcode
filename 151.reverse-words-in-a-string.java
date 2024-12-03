/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    /**
     * Use String.split to create String[]
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 93.64% (5 ms)
     * memory: 39.53% (43.4 MB)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] subs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = subs.length - 1; i >= 0; i--) {
            if (subs[i] != "") {
                sb.append(subs[i]).append(' ');
            }
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
// @lc code=end
