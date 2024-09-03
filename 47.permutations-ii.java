/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * 使用 Backtracking 和 Boolean Array 輔助
     * Time Complexity: O(n!) (Worst Case)
     * runtime: 99.9% (1 ms)
     * memory: 73.37% (44.6 MB)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(resultList, list, visited, nums);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 當前index已經在list裡面，則略過
            if (visited[i]) {
                continue;
            }

            // 當前index與上個index的數字相同，則略過
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);

            backtrack(resultList, list, visited, nums);
            // backtracking 關鍵，移除最後元素
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    
    }
}
// @lc code=end

