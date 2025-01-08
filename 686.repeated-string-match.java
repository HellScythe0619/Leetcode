/*
 * @lc app=leetcode id=686 lang=java
 *
 * [686] Repeated String Match
 */

// @lc code=start
class Solution {
    /**
     * 從String a開始重複拼接，直到包含String b
     * Time complexity: O(n * (m + n))
     * Space complexity: O(m + n)
     * m: the length of String a
     * n: the length of String b
     * 
     * runtime: 36.32% (269 ms)
     * memory: 30.3% (45.1 MB)
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);
        while (!sb.toString().contains(b)) {
            if (sb.length() > b.length() + a.length()) {
                return -1;
            }
            sb.append(a);
            count++;
        }
        return count;
    }
}
// @lc code=end

