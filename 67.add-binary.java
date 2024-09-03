/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';   // 轉成int
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';   // 轉成int
            }
            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

