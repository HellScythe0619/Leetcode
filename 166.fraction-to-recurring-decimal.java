/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    /**
     * 將分數轉換成小數
     * 使用 HashMap 標記 循環小數 的起始位置
     * 
     * runtime: 99.24% (1 ms)
     * memory: 18.61% (41.2 MB)
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        // 分子 numerator 為 0，則值為 0
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // 分子 numerator 和 分母 denominator 正負不一致，則值必有"-"負號
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }

        // 轉換成 long 型態，防止 int overflow
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);

        // 先取整數
        sb.append(num / deno);
        // 取餘數
        long remainder = num % deno;
        if (remainder != 0) {
            sb.append(".");
            // 將餘數標記，防止循環小數
            HashMap<Long, Integer> map = new HashMap<>();
            while (remainder != 0) {
                // 當前餘數已在map中，代表為循環
                if (map.containsKey(remainder)) {
                    sb.insert(map.get(remainder), "(");
                    sb.append(")");
                    break;
                }

                // 標記當前餘數的長度
                map.put(remainder, sb.length());

                // 不斷將餘數被除
                remainder *= 10;
                sb.append(remainder / deno);
                remainder %= deno;
            }
        }

        return sb.toString();
    }
}
// @lc code=end

