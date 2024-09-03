/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * use HashSet
     * runtime: 44%
     * memory: 41.78% (44.6 MB)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startIndex = 0;
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charSet.contains(s.charAt(i))) {
                charSet.add(s.charAt(i));
                maxLength = Math.max(maxLength, i - startIndex + 1);
            } else {
                while (charSet.contains(s.charAt(i))) {
                    charSet.remove(s.charAt(startIndex));
                    startIndex++;
                }
                charSet.add(s.charAt(i));
            }
        }

        return maxLength;
    }
}
// @lc code=end

