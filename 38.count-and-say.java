/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    /**
     * Run-Length Encoding(RLE，運行長度編碼)
     * example: 
     *  "1" -> "11" (1個"1")
     *  "123" -> "111213" (1個"1"+1個"2"+1個"3")
     *  "33334455566" -> "43243526" (4個"3"+2個"4"+3個"5"+2個"6")
     * runtime: 88.89%
     * memory: 84.23% (41 MB)
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            // 最後字元 or (當前字元 != 下一個字元)
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(count).append(str.charAt(i));
                count = 0;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

