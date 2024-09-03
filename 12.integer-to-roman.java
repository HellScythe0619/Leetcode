/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 創建字典 O(1) 無腦但最快
     * runtime: 56.2%
     * memory: 63.3% (44.2 MB)
     * @param num
     * @return
     */
    // public String intToRoman(int num) {
    //     String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    //     String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    //     String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    //     String[] thousands = { "", "M", "MM", "MMM" };
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(thousands[num / 1000]);
    //     sb.append(hundreds[(num % 1000) / 100]);
    //     sb.append(tens[(num % 100) / 10]);
    //     sb.append(ones[num % 10]);
    //     return sb.toString();
    // }

    /**
     * Myself update O(N)
     * runtime: 31.59%
     * memory: 37.32% (44.5 MB)
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Map<Integer, String[]> powerMap = new HashMap<>();
        powerMap.put(1, new String[] { "I", "V", "X" });
        powerMap.put(2, new String[] { "X", "L", "C" });
        powerMap.put(3, new String[] { "C", "D", "M" });
        powerMap.put(4, new String[] { "M" });

        StringBuilder sb = new StringBuilder();
        int power = 1;
        while (num != 0) {
            int digit = num % 10;
            StringBuilder temp = new StringBuilder();
            if (digit <= 3) {
                for (int i = 0; i < digit; i++) {
                    temp.append(powerMap.get(power)[0]);
                }
            } else if (digit == 4) {
                temp.append(powerMap.get(power)[0]);
                temp.append(powerMap.get(power)[1]);
            } else if (digit > 4 && digit < 9) {
                temp.append(powerMap.get(power)[1]);
                for (int i = 0; i < digit - 5; i++) {
                    temp.append(powerMap.get(power)[0]);
                }
            } else if (digit == 9) {
                temp.append(powerMap.get(power)[0]);
                temp.append(powerMap.get(power)[2]);
            }
            sb.insert(0, temp);

            power++;
            num /= 10;
        }

        return sb.toString();
    }

}
// @lc code=end

