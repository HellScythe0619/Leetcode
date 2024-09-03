/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * runtime: 100% (0 ms)
     * memory: 77.9% (44.3 MB)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, nums, 0);
        return resultList;
    }

    // swap1:[1,2,3]
    // swap1:[1,2,3]
    // resultList:[[1,2,3]]
    // swap2:[1,2,3]
    // swap1:[1,3,2]
    // resultList:[[1,2,3][1,3,2]]
    // swap2:[1,2,3]
    // swap2:[1,2,3]
    // swap1:[2,1,3]
    // swap1:[2,1,3]
    // resultList:[[1,2,3][1,3,2][2,1,3]]
    // swap2:[2,1,3]
    // swap1:[2,3,1]
    // resultList:[[1,2,3][1,3,2][2,1,3][2,3,1]]
    // swap2:[2,1,3]
    // swap2:[1,2,3]
    // swap1:[3,2,1]
    // swap1:[3,2,1]
    // resultList:[[1,2,3][1,3,2][2,1,3][2,3,1][3,2,1]]
    // swap2:[3,2,1]
    // swap1:[3,1,2]
    // resultList:[[1,2,3][1,3,2][2,1,3][2,3,1][3,2,1][3,1,2]]
    // swap2:[3,2,1]
    // swap2:[1,2,3]
    private void backtrack(List<List<Integer>> resultList, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            resultList.add(list);
            // testList(resultList);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            // testLog(nums, true);
            backtrack(resultList, nums, index + 1);
            swap(nums, index, i);
            // testLog(nums, false);
        }
    }

    // private void testList(List<List<Integer>> resultList) {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append("resultList:");
    //     sb.append("[");
    //     for (List<Integer> list : resultList) {
    //         sb.append("[");
    //         for (int num : list) {
    //             sb.append(num).append(",");
    //         }
    //         sb.deleteCharAt(sb.length() - 1);
    //         sb.append("]");
    //     }
        
    //     sb.append("]");
    //     System.out.println(sb.toString());
    // }

    // private void testLog(int[] nums, boolean swap) {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(swap ? "swap1:" : "swap2:");
    //     sb.append("[");
    //     for (int num : nums) {
    //         sb.append(num).append(",");
    //     }
    //     sb.deleteCharAt(sb.length() - 1);
    //     sb.append("]");
    //     System.out.println(sb.toString());
    // }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

