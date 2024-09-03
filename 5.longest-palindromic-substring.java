/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming O(n^2)
     * Steps:
     * 1. initialize a boolean table "check" and mark all the values as false.
     * 2. "max_len" to keep track of the maximum length of the palindrome.
     * 3. iterate over the string and mark the diagonal elements as true as every single character is a palindrome.
     * 4. For odd length palindrome, we will consider the current character as the center and expand around it.
     * 5. For even length palindrome, we will consider the current character and the next character as the center and expand around it.
     * 6. keep track of the maximum length and the maximum substring.
     * runtime: 46.82%
     * memory: 14.4% (46.4 MB)
     * @param s
     * @return
     */
    // public String longestPalindrome(String s) {
    //     if (s.length() == 1) {
    //         return s;
    //     }

    //     int maxLength = 1;
    //     int start = 0;
    //     int end = 0;
    //     boolean[][] check = new boolean[s.length()][s.length()];

    //     for (int i = 0; i < s.length(); i++) {
    //         check[i][i] = true;
    //         for (int j = 0; j < i; j++) {
    //             if (s.charAt(j) == s.charAt(i) &&
    //                     (i - j <= 2 || check[j + 1][i - 1])) {
    //                 check[j][i] = true;
    //                 if (i - j + 1 > maxLength) {
    //                     maxLength = i - j + 1;
    //                     start = j;
    //                     end = i;
    //                 }
    //             }
    //         }
    //     }

    //     return s.substring(start, end + 1);
    // }
    
    
    /**
     * Manacher's Algorithm O(n) -> for Longest Palindromic Substring (LPS)
     * runtime: 25.83%
     * memory: 47.11% (45.1 MB)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLength = 1;
        String maxString = s.substring(0, 1);
        s = "#" + s.replaceAll("", "#") + "#";
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0
                    && i + dp[i] + 1 < s.length()
                    && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxString = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxString;
    }

}
// @lc code=end

