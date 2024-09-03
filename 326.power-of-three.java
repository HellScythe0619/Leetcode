/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N^2 * N)
     * runtime: 89.72% (8 ms)
     * memory: 79.7% (43.8 MB)
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
// @lc code=end

