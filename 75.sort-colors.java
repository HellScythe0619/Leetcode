/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    /**
     * Use HashMap count color then sort
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 23.98% (1 ms)
     * memory: 16.58% (42 MB)
     * @param nums
     */
    // public void sortColors(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }

    //     int index = 0;
    //     for (int i = 0; i < 3; i++) {
    //         if (map.containsKey(i)) {
    //             int count = map.get(i);
    //             for (int j = 0; j < count; j++) {
    //                 nums[index] = i;
    //                 index++;
    //             }
    //         }
    //     }
    // }

    /**
     * Two-Pointers (Three pointer)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (0 ms)
     * memory: 79.37% (41.6 MB)
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero_red = 0;   // 同時作為 left
        int one_white = 0;  // 同時作為 current指標
        int two_blue = nums.length - 1; // 同時作為 right

        while (one_white <= two_blue) {
            if (nums[one_white] == 0) {
                // 當前 current指標 為 0_red

                // 交換 zero_red 和 one_white 位置
                int temp = nums[one_white];
                nums[one_white] = nums[zero_red];
                nums[zero_red] = temp;

                zero_red++;
                one_white++;
            } else if (nums[one_white] == 1) {
                // 當前 current指標 為 1_white

                // PASS當前，往下一個位置移動
                one_white++;
            } else {
                // 當前 current指標 為 2_blue

                // 交換 one_white 和 two_blue 位置
                int temp = nums[one_white];
                nums[one_white] = nums[two_blue];
                nums[two_blue] = temp;

                two_blue--;
            }
        }
    }

}
// @lc code=end

