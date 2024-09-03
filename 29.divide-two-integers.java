/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    /**
     * 右移運算子">>": N >>= 1 === N/2
     * 左移運算子"<<": N <<= 1 === N*2
     * 波浪號運算子"~": ~N === -(N+1)
     * 絕對值 Math.abs(): Math.abs(N) === |N|
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long quot = 0;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long count = 1;
            while (temp <= absDividend) {
                temp <<= 1;
                count <<= 1;
            }
            quot += count >> 1;
            absDividend -= temp >> 1;
        }
        return isNegative ? (int) ~quot + 1 : quot > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quot;
    }
}
// @lc code=end

