/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    // public boolean isPowerOfTwo(int n) {
    //     if (n == 1) {
    //         return true;
    //     } else if (n <= 0 || n % 2 != 0) {
    //         return false;
    //     } else if (n == 2) {
    //         return true;
    //     }
    //     return getQuotient(n / 2);
    // }

    // private boolean getQuotient(int quot) {
    //     if (quot % 2 != 0) {
    //         return false;
    //     } else if (quot > 2) {
    //         return getQuotient(quot / 2);
    //     }
    //     return quot % 2 == 0 ? true : false;
    // }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        } else if ((n == 1) || (n % 2 == 0 && isPowerOfTwo(n / 2))) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

