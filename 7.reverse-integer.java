/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    /**
     * convert to String
     * runtime: 5.45%
     * memory: 6.64% (41.7 MB)
     * @param x
     * @return
     */
    // public int reverse(int x) {
    //     if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
    //         return 0;
    //     }

    //     boolean isNegative = x < 0;
    //     String num = String.valueOf(Math.abs(x));
    //     String result = "";
    //     for (int i = num.length() - 1; i >= 0; i--) {
    //         result += num.charAt(i);
    //     }

    //     long numLong = Long.parseLong(result);
    //     if (numLong > (long) Integer.MAX_VALUE) {
    //         return 0;
    //     }

    //     if (isNegative) {
    //         result = "-" + result;
    //     }

    //     return Integer.parseInt(result);
    // }

    /**
     * Convert to String (Simple version)
     * runtime: 8.28%
     * memory: 54.57% (40.7 MB)
     * @param x
     * @return
     */
    // public int reverse(int x) {
    //     boolean isNegative = x < 0;
    //     String str = String.valueOf(Math.abs(x));
    //     // 使用 StringBuilder.reverse() 解決倒數
    //     StringBuilder sb = new StringBuilder(str).reverse();

    //     try {
    //         return isNegative ? -Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
    //     } catch (NumberFormatException e) {
    //         return 0;
    //     }
    // }


    /**
     * use remainder 餘數方法
     * Note: 因為 input 是 int type 故不會超過 long 範圍，
     *      如果 input 是 String or Array，則要用 String 接值。
     * runtime: 100%
     * memory: 67.05% (40.6 MB)
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0;
        int remainder = 0;  // 減少 memory 消耗
        while (x != 0) {
            remainder = x % 10;
            result = result * 10 + remainder;
            x /= 10;
        }

        // Integer Overflow
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) result;
    }
    


}
// @lc code=end

