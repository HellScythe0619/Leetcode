/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Two HashMap
     * Time Complexity: O(2N)
     * Space Complexity: O(2N)
     * 
     * runtime: 57.36% (11 ms)
     * memory: 75.21% (42.1 MB)
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> souceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!souceMap.containsKey(s.charAt(i))) {
                souceMap.put(s.charAt(i), t.charAt(i));
            } else if (souceMap.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }

        Map<Character, Character> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!targetMap.containsKey(t.charAt(i))) {
                targetMap.put(t.charAt(i), s.charAt(i));
            } else if (targetMap.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

