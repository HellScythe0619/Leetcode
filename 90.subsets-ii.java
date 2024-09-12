/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Backtrack 回溯
     * runtime: 99.93% (1 ms)
     * memory: 66.68% (43.4 MB)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 排序 防止亂序
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrack(resultList, list, nums, 0);
        return resultList;
    }

    /**
     * 透過 backtrack 回溯
     * @param resultList
     * @param list
     * @param nums
     * @param index
     */
    private void backtrack(List<List<Integer>> resultList, List<Integer> list, int[] nums, int index) {
        resultList.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            // 即第二個資料開始比對前一項是否相同數字，如果相同則跳過
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            backtrack(resultList, list, nums, i + 1);
            // back
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

