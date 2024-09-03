/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Backtracking (Recursive Approach) 回溯 (遞迴解法)
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(2^N)
     * 
     * rumtime: 53.37% (1 ms)
     * memory: 43.96% (42.6 MB)
     * @param nums
     * @return
     */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> resultList = new ArrayList<>();
    //     List<Integer> list = new ArrayList<>();
    //     backtrack(resultList, nums, list, 0);
    //     return resultList;
    // }

    // private void backtrack(List<List<Integer>> resultList, int[] nums, List<Integer> list, int start) {
    //     resultList.add(new ArrayList<>(list));
    //     for (int i = start; i < nums.length; i++) {
    //         list.add(nums[i]);
    //         backtrack(resultList, nums, list, i + 1);
    //         list.remove(list.size() - 1);
    //     }
    // }

    /**
     * Iterative Approach (Generating all subsets)
     * (Memory Limit Exceeded)
     * rumtime: 
     * memory: 
     * @param nums
     * @return
     */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> resultList = new ArrayList<>();
    //     resultList.add(new ArrayList<>());

    //     for (int num : nums) {
    //         // 對每個既有的resultList子集加數字，從空的加到全部
    //         /**
    //          * resultList 子集衍生順序
    //          * init:    null
    //          * num[0]:  null -> [ num[0] ]
    //          * num[1]:  null -> [ num[1] ]
    //          *          [ num[0] ] -> [ num[0], num[1] ]
    //          * num[2]:  null -> [ num[2] ]
    //          *          [ num[0] ] -> [ num[0], num[2] ]
    //          *          [ num[1] ] -> [ num[1], num[2] ]
    //          *          [ num[0], num[1] ] -> [ num[0], num[1], num[2] ]
    //          */
    //         for (int i = 0; i < resultList.size(); i++) {
    //             List<Integer> subset = new ArrayList<>(resultList.get(i));
    //             subset.add(num);
    //             resultList.add(subset);
    //         }
    //     }

    //     return resultList;
    // }

    /**
     * Bit Manipulation 位元操作 (此題最佳解法)
     * runtime: 100% (0 ms)
     * memory: 62.61% (42.6 MB)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        /**
         * Example:
         *  nums.length = 3
         *  1 << 3 ==> 2^3 ==> 8
         */
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                /**
                 * &: Bit位元操作，兩個位元數的相應操作數均為 1，則結果位元為 1，否則為 0。
                 * Example: 10 & 12 = 8
                 *  10 -> 1010, 12 -> 1100, 10 & 12 -> 1000 -> 8
                 * Example: nums.length = 3
                 *  i: 0, j: 0, (0 & (1 << 0)): 0
                 *        j: 1, (0 & (1 << 1)): 0
                 *        j: 2, (0 & (1 << 2)): 0
                 *  [ [] ]
                 *  i: 1, j: 0, (1 & (1 << 0)): 1 & 1 -> 1
                 *        j: 1, (1 & (1 << 1)): 0
                 *        j: 2, (1 & (1 << 2)): 0
                 *  [ [], [1] ]
                 *  i: 2, j: 0, (2 & (1 << 0)): 0
                 *        j: 1, (2 & (1 << 1)): 10 & 10 -> 2
                 *        j: 2, (2 & (1 << 2)): 0
                 *  [ [], [1], [2] ]
                 *  i: 3, j: 0, (3 & (1 << 0)): 11 & 01 -> 1
                 *        j: 1, (3 & (1 << 1)): 11 & 10 -> 2
                 *        j: 2, (3 & (1 << 2)): 0
                 *  [ [], [1], [2], [1, 2] ]
                 *  i: 4, j: 0, (4 & (1 << 0)): 0
                 *        j: 1, (4 & (1 << 1)): 0
                 *        j: 2, (4 & (1 << 2)): 100 & 100 -> 4
                 *  [ [], [1], [2], [1, 2], [3] ]
                 *  i: 5, j: 0, (5 & (1 << 0)): 101 & 001 -> 1
                 *        j: 1, (5 & (1 << 1)): 0
                 *        j: 2, (5 & (1 << 2)): 101 & 100 -> 4
                 *  [ [], [1], [2], [1, 2], [3], [1, 3] ]
                 *  i: 6, j: 0, (6 & (1 << 0)): 0
                 *        j: 1, (6 & (1 << 1)): 110 & 010 -> 2
                 *        j: 2, (6 & (1 << 2)): 110 & 100 -> 4
                 *  [ [], [1], [2], [1, 2], [3], [1, 3], [2, 3] ]
                 *  i: 7, j: 0, (7 & (1 << 0)): 111 & 001 -> 1
                 *        j: 1, (7 & (1 << 1)): 111 & 010 -> 2
                 *        j: 2, (7 & (1 << 2)): 111 & 100 -> 4
                 *  [ [], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3] ]
                 */
                // System.out.println("i: " + i + ", j: " + j + ", (" + i + " & ( 1 << " + j + " )): " + (i & (1 << j)));
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            resultList.add(subset);
        }

        return resultList;
    }
}
// @lc code=end

