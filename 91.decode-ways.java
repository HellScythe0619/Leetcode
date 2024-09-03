/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    /**
     * Dynamic Programming (DP)
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 79.6% (1 ms)
     * memory: 87.8% (41.3 MB)
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int length = s.length();

        // 即計算 string s 各長度的組合數
        int[] dp = new int[length + 1];
        // empty string -> 1 set
        dp[0] = 1;

        // 取當前第一個字，如不為'0'，則必定組合為1組。
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        } else {
            // example: "082" -> "0" 找不到對應的字母，故組合為0組。
            return 0;
        }

        for (int i = 2; i < length + 1; i++) {
            // 當前字元為1-9
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // 若前一個字元為1或(2且當前字元為0-6)
            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        /**
         * ""                           1組 (default)
         * "1": A                       1組 (default)
         * "11": AA K                   2組
         * "111": AAA KA AK             3組
         * "1111": AAAA KAA AKA AAK KK  5組
         */


        // 取得 s.length() 長度的 組合數
        return dp[length];        
    }
}
// @lc code=end

