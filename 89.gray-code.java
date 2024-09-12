/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start

import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

class Solution {
    /**
     * Time Complexity: O(2^N)
     * Space Complexity: O(2^N)
     * 
     * runtime: 27.11% (10 ms)
     * memory: 90.15% (50.9 MB)
     * @param n
     * @return
     */
    // public List<Integer> grayCode(int n) {
    //     /**
    //      * n = 2
    //      * [0,1,3,2]
    //      * 0 0
    //      * 0 1
    //      * ---
    //      * 1 1
    //      * 1 0
    //      * 
    //      * n = 3
    //      * [0,1,3,2,6,7,5,4]
    //      * 0 0 0
    //      * 0 0 1
    //      * 0 1 1
    //      * 0 1 0
    //      * -----
    //      * 1 1 0
    //      * 1 1 1
    //      * 1 0 1
    //      * 1 0 0
    //      * 鏡像，每2^n就reverse當前List，再加2^i數字成新的List
    //      * 
    //      * n = 4
    //      * [0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8]
    //      */
    //     List<Integer> resultList = new ArrayList<>();
    //     resultList.add(0);

    //     for (int i = 0; i < n; i++) {
    //         List<Integer> list = new ArrayList<>(resultList);
    //         // 鏡像反轉當前List
    //         Collections.reverse(list);
    //         // 加上當前的2^i，組成新的後半List
    //         int power = (int) Math.pow(2, i);
    //         for (int num : list) {
    //             resultList.add(num + power);
    //         }
    //     }

    //     return resultList;
    // }

    /**
     * 使用 ^ XOR 邏輯 與 >> << 邏輯 操作處理
     * runtime: 98.59% (4 ms)
     * memory: 55.54% (51.5 MB)
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> resultList = new ArrayList<>();
        /**
         * 1 << n 即 2^n (向左移n位)
         * Example: n = 3, 1 << 3 = 2^3 = 8
         * i >> 1 即 i/(2^1) (向右移1位) (bit)
         * Example: 
         *  i = 2, 2 >> 1 = 2/2 = 1 = 10 >> 1
         *  i = 3, 3 >> 1 = 3/2 = 1 = 11 >> 1
         *  i = 4, 4 >> 1 = 4/2 = 2 = 100 >> 1 = 10
         * i ^ (i >> 1) 即 i XOR (i >> 1)
         * XOR truth table: (01 or 10 才會是 1)
         *      0   1
         *  0   0   1
         *  1   1   0
         * Example: 
         *  i = 2, 2 ^ (2 >> 1) = 2 ^ 1 = 10 ^ 01 = 11 = 3
         *  i = 3, 3 ^ (3 >> 1) = 3 ^ 1 = 11 ^ 01 = 10 = 2
         *  i = 4, 4 ^ (4 >> 1) = 4 ^ 2 = 100 ^ 010 = 110 = 6
         */
        for (int i = 0; i < (1 << n); i++) {
            resultList.add(i ^ (i >> 1));
        }

        return resultList;
    }
}
// @lc code=end

