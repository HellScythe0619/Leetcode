/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
    /**
     * Use KMP Algorithm, LPS
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 89.13% (6 ms)
     * memory: 9.15% (45.5 MB)
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String reverse = new StringBuilder(s).reverse().toString();
        // 建立新的迴文
        String combined = new StringBuilder(s).append("#").append(reverse).toString();

        // 建立 KMP Array (LPS)
        int[] kmp = buildKMP(combined);
        // 找到 最長的迴文前綴長度，即 KMP Array 的 最後index
        int longestPalindromicPrefixLength = kmp[combined.length() - 1];
        // 非迴文的片段
        String nonPalidromicPart = reverse.substring(0, s.length() - longestPalindromicPrefixLength);

        return new StringBuilder(nonPalidromicPart).append(s).toString();
    }

    private int[] buildKMP(String str) {
        int[] kmp = new int[str.length()];

        // the previous longest prefix suffix
        int length = 0;
        for (int i = 1; i < str.length(); i++) {
            while (length > 0 && str.charAt(i) != str.charAt(length)) {
                length = kmp[length - 1];
            }
            if (str.charAt(i) == str.charAt(length)) {
                length++;
            }
            kmp[i] = length;
        }

        return kmp;
    }
}
// @lc code=end
