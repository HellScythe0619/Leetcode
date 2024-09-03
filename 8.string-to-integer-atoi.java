/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    /**
     * Myself
     * runtime: 35.92%
     * memory: 59.87% (42.2 MB)
     * @param s
     * @return
     */
    // public int myAtoi(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     boolean isPositive = false;
    //     boolean isNegative = false;
    //     for (char c : s.toCharArray()) {
    //         if (Character.isSpaceChar(c)) {
    //             if (sb.length() == 0 && !isPositive && !isNegative) {
    //                 continue;
    //             } else {
    //                 break;
    //             }
    //         }

    //         if (c == '-') {
    //             if (sb.length() == 0 && !isPositive && !isNegative) {
    //                 isNegative = true;
    //                 continue;
    //             } else {
    //                 break;
    //             }
    //         } else if (c == '+') {
    //             if (sb.length() == 0 && !isPositive && !isNegative) {
    //                 isPositive = true;
    //                 continue;
    //             } else {
    //                 break;
    //             }
    //         }

    //         if (!Character.isDigit(c)) {
    //             break;
    //         } else {
    //             sb.append(c);
    //         }
    //     }

    //     if (sb.length() == 0) {
    //         sb.append(0);
    //     } else if (isNegative) {
    //         sb.insert(0, '-');
    //     }

    //     try {
    //         long longNum = Long.parseLong(sb.toString());
    //         if (longNum > Integer.MAX_VALUE) {
    //             return Integer.MAX_VALUE;
    //         } else if (longNum < Integer.MIN_VALUE) {
    //             return Integer.MIN_VALUE;
    //         } else {
    //             return (int) longNum;
    //         }
    //     } catch (Exception e) {
    //         return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    //     }
    // }
    
    /**
     * runtime: 100%
     * memory: 73.91% (42.2 MB)
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        int result = 0;
        int sign = 1;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        if (s.length() == 0) {
            return 0;
        }

        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            if (s.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }

        while (index < s.length() && s.charAt(index) - '0' <= 9 && s.charAt(index) - '0' >= 0) {
            int digit = s.charAt(index) - '0';
            if (result > max / 10 || (result == max / 10 && digit > max % 10)) {
                return sign == 1 ? max : min;
            }
            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }


}
// @lc code=end

