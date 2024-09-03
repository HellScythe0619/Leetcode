/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    // public int singleNumber(int[] nums) {
    //     Map<Integer, Integer> resultMap = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!resultMap.containsKey(nums[i])) {
    //             resultMap.put(nums[i], 1);
    //         } else {
    //             resultMap.put(nums[i], resultMap.get(nums[i]) + 1);
    //         }
    //     }

    //     int result = 0;
    //     for (Integer key : resultMap.keySet()) {
    //         if (resultMap.get(key) != 2) {
    //             result = key;
    //             break;
    //         }
    //     }

    //     return result;
    // }

    /**
     * Using Bit Manipulation (XOR) 位元操作
     * a XOR 0 = a
     * a XOR a = 0
     * (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4)
     * = 2 ^ 3 ^ 4
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
// @lc code=end

