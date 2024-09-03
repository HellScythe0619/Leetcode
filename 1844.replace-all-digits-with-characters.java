/*
 * @lc app=leetcode id=1844 lang=java
 *
 * [1844] Replace All Digits with Characters
 */

// @lc code=start
class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                char targetChar = s.charAt(i - 1);
                int shiftInt = s.charAt(i) - '0';
                sb.append(this.shift(targetChar, shiftInt));
            }
        }

        return sb.toString();
    }

    private char shift(char targetChar, int shiftInt) {
        return (char) (targetChar + shiftInt);
    }
}
// @lc code=end

