/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * 經由層層遞迴找到當前數字的排列序
     * 
     * runtime: 92.78% (1 ms)
     * memory: 44.19% (41.1 MB)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        // 組成候選數列
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        recursiveHelper(numList, result, k);

        return result.toString();
    }

    private void recursiveHelper(List<Integer> numList, StringBuilder result, int k) {
        // 如果 numList.size() == 0，即 n = 0，代表組完
        if (numList.size() == 0) {
            return;
        }

        // 按當前數字分組，每組的可能排序組合數量，即 (n - 1)!
        int combinations = factorial(numList.size() - 1);
        /**
         * 當前數字在 numList 對應的 index
         * k - 1: 因為index是從0開始，所以要先-1
         * k 通常會大於 combinations，因為 combination = (n - 1)!
         */
        int index = (k - 1) / combinations;

        result.append(numList.get(index));
        // 當前數字找到後，就移除該數字，使得 numList.size() - 1，也就是當前 n - 1
        numList.remove(index);

        /**
         * 尋找下一位數字的對應排列序
         * 下一個 k = (當前 k) - index * combinations
         * index * combination = index * (n - 1)! 
         */
        recursiveHelper(numList, result, k - index * combinations);
    }

    /**
     * 找到當前每組的組合數
     * @param n
     * @return
     */
    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
// @lc code=end

