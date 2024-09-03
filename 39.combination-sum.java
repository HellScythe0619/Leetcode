/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * runtime: 85.27%
     * memory: 74.34% (44.3 MB)
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        recursive(resultList, sumList, candidates, target, 0);
        return resultList;
    }

    private void recursive(List<List<Integer>> resultList, List<Integer> sumList, int[] candidates, int target,
            int index) {
        // 最後一位
        if (index == candidates.length) {
            // 剛好為0則加入
            if (target == 0) {
                resultList.add(new ArrayList<>(sumList));
            }
            return;
        }

        // 當前candidate小於target
        if (candidates[index] <= target) {
            sumList.add(candidates[index]);
            recursive(resultList, sumList, candidates, target - candidates[index], index);
            sumList.remove(sumList.size() - 1); // 避免重複加
        }

        // 判斷下一個candidate
        recursive(resultList, sumList, candidates, target, index + 1);
    }
}
// @lc code=end

