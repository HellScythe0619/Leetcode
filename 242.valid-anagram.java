/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    /**
     * Use HashMap
     * runtime: 26.06% (15 ms)
     * memory: 28.06% (44.7 MB)
     * @param s
     * @param t
     * @return
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for (char c : s.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //     for (char c : t.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) - 1);
    //     }

    //     for (int value : map.values()) {
    //         if (value != 0) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    /**
     * Use Array sort
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     * runtime: 88.99% (3 ms)
     * memory: 37.83% (44.6 MB)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}
// @lc code=end

