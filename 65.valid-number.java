/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (1 ms)
     * memory: 98.88% (41.9 MB)
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        boolean digitCheck = false;
        boolean exponentCheck = false;
        boolean dotCheck = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitCheck = true;
            } else if (c == '-' || c == '+') {
                /**
                 * 當前 -+ 符號不是在最前面，且不是接在e|E後面 (ex: "3e+7")
                 */
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (exponentCheck || !digitCheck) {
                    /**
                     * exponentCheck 為 true 代表 前面已出現 e|E
                     * !digitCheck 為 true 代表 前面沒有數字
                     */
                    return false;
                }
                /**
                 * 將 exponentCheck 為 true 表示已出現 e|E
                 * 將 digitCheck 為 false 因為當前不是一組數字，e|E後面需要接數字
                 */
                exponentCheck = true;
                digitCheck = false;
            } else if (c == '.') {
                if (dotCheck || exponentCheck) {
                    /**
                     * dotCheck 為 true 代表 前面已出現 dot
                     * exponentCheck 為 true 則不該有 dot (ex: "99e2.5")
                     */
                    return false;
                }
                dotCheck = true;
            } else {
                // 非數字，也非-+、e|E、'.'
                return false;
            }
        }

        return digitCheck;
    }
}
// @lc code=end

