/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /**
     * 使用 recursive 遞迴計算 O(log n)
     * 關鍵在 stackOverflow，需將次方數從int轉long防止溢出。
     * 並判斷當前x是否可以簡化成 x^2 計算，省去次方loop次數。
     * runtime: 100%
     * memory: 33.95% (42.3MB)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long pow = n;
        // 將次方數轉正，防止每次recursive都要判斷x|1/x。
        if (pow < 0) {
            pow = -pow;
            x = 1 / x;
        }

        if (pow % 2 == 0) {
            return myPow(x * x, (int) (pow / 2));
        } else {
            return x * myPow(x, (int) (pow - 1));
        }
    }
}
// @lc code=end

