/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int wordLength = 0;
        boolean isSpacePass = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (isSpacePass) {
                    continue;
                } else {
                    break;
                }
            } else {
                wordLength++;
                isSpacePass = false;
            }
        }
        return wordLength;
    }
}
// @lc code=end

