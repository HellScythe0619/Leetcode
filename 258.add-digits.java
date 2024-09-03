/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    /**
     * runtime: 47.9% (1 ms)
     * memory: 72.22% (40.6 MB)
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            num = addDigits(num / 10) + num % 10;
        }
        return addDigits(num);
    }
}
// @lc code=end

