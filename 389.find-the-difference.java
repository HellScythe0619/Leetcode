/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start

class Solution {
    /**
     * Use XOR byte manipulation (XOR 位元操作)
     * 透過 XOR 篩選出多出來的數字or字元
     * XOR truth table:
     *  0 0 -> 0
     *  1 0 -> 1
     *  0 1 -> 1
     *  1 1 -> 0
     * Example: 5 XOR 5 = 0
     *  -> 0101 XOR 0101
     *  -> 0101 ^ 0101
     *  -> 0000
     *  -> 0
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (1 ms)
     * memory: 42.13% (41.8 MB)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char difference = 0;
        // 先將 String s 塞入
        for (char c : s.toCharArray()) {
            difference ^= c; // difference = difference ^ c (^ -> XOR)
        }
        // 再用 String t 篩掉相同的字元，就會剩下最後一個多餘的字元
        for (char c : t.toCharArray()) {
            difference ^= c;
        }
        return difference;
    }
}
// @lc code=end

