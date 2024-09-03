/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    /**
     * Binary Search
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (0 ms)
     * memory: 94.39% (39.8 MB)
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int pick = guess(mid);
            if (pick == 0) {
                return mid;
            } else if (pick == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
// @lc code=end

