/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 遞迴直接找到解 (Recursive)
     * Time Limit Exceeded (O(2^n))
     * @param n
     * @return
     */
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    /**
     * 使用Map紀錄解，防止重複算 (Memoization)
     * 0ms, runtime: 100%, memory: 9.81% (39.6MB)
     * @param n
     * @return
     */
    // public int climbStairs(int n) {
    //     Map<Integer, Integer> resultMap = new HashMap<>();
    //     return memoClimbStairs(n, resultMap);
    // }

    // public int memoClimbStairs(int n, Map<Integer, Integer> resultMap) {
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }
    //     if (!resultMap.containsKey(n)) {
    //         resultMap.put(n, memoClimbStairs(n - 1, resultMap) + memoClimbStairs(n - 2, resultMap));
    //     }
    //     return resultMap.get(n);
    // }

    /**
     * 使用 Dymanic Programming (n+1 table)
     * 解決遞迴方式
     * 0ms, runtime: 100%, memory: 44.03% (39.1MB)
     * @param n
     * @return
     */
    // public int climbStairs(int n) {
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }

    //     int[] resultArray = new int[n + 1];
    //     resultArray[0] = 1;
    //     resultArray[1] = 1;

    //     for (int i = 2; i < n + 1; i++) {
    //         resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
    //     }
    //     return resultArray[n];
    // }

    /**
     * 空間優化 (Space Optimization)
     * 放棄使用DP表，降低空間複雜度，使用兩個變數即可。
     * curr = 前兩個值的和
     * prev = 儲存前一個curr的值
     * 0ms, runtime: 100%, memory: 57.1% (39.1MB)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
// @lc code=end

