/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> romanNumberMap = new HashMap<>();
        romanNumberMap.put('I', 1);
        romanNumberMap.put('V', 5);
        romanNumberMap.put('X', 10);
        romanNumberMap.put('L', 50);
        romanNumberMap.put('C', 100);
        romanNumberMap.put('D', 500);
        romanNumberMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && romanNumberMap.get(s.charAt(i)) < romanNumberMap.get(s.charAt(i+1))) {
                result -= romanNumberMap.get(s.charAt(i));
            } else {
                result += romanNumberMap.get(s.charAt(i));
            }
        }

        return result;
    }
}
// @lc code=end

