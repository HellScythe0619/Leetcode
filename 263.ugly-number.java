/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     * 
     * runtime: 45.73% (1 ms)
     * memory: 88.78% (40.4 MB)
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) {
            return isUgly(n / 2);
        }
        if (n % 3 == 0) {
            return isUgly(n / 3);
        }
        if (n % 5 == 0) {
            return isUgly(n / 5);
        }

        return false;
    }
}
// @lc code=end

