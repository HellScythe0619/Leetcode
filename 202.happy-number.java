/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> resultSet = new HashSet<>();
        // 使用HashSet防止重複數字形成無限迴圈
        while (n != 1 && !resultSet.contains(n)) {
            resultSet.add(n);
            int sum = 0;
            while (n != 0) {
                // 取得當前個位數進行平方和加總
                int num = n % 10;
                sum += num * num;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
// @lc code=end

