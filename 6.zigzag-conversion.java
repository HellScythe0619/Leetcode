/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    /**
     * 之字形字串轉換 O(n)
     * Example: ABCDEFGHIJKL , row = 4
     *          123432123432
     *      ->  AG BFHL CEIK DJ
     * runtime: 80.07%
     * memory: 89.33% (44.5 MB)
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int index = 0;
        int direction = 1;
        StringBuilder[] rowSb = new StringBuilder[numRows];
        // 將 StringBuilder Array null初始化
        for (int i = 0; i < numRows; i++) {
            rowSb[i] = new StringBuilder();
        }

        for (char c : s.toCharArray()) {
            rowSb[index].append(c);
            if (index == 0) {
                direction = 1;
            } else if (index == numRows - 1) {
                direction = -1;
            }
            index += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rowSb) {
            sb.append(row);
        }
        
        return sb.toString();
    }
}
// @lc code=end

