/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * runtime: 82.83%
     * memory: 78.97% (42.9 MB)
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 依小到大排序
        Arrays.sort(candidates);
        List<Integer> sumList = new ArrayList<>();
        recursive(resultList, sumList, candidates, target, 0);
        return resultList;
    }

    private void recursive(List<List<Integer>> resultList, List<Integer> sumList, int[] candidates, int target,
            int index) {
        if (index == candidates.length || candidates[index] > target) {
            if (target == 0) {
                resultList.add(new ArrayList<>(sumList));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            sumList.add(candidates[i]);
            recursive(resultList, sumList, candidates, target - candidates[i], i + 1);
            sumList.remove(sumList.size() - 1); // 避免重複加
        }

        return;
    }
}
// @lc code=end

