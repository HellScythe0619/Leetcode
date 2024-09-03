/*
 * @lc app=leetcode id=2363 lang=java
 *
 * [2363] Merge Similar Items
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }

        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for (Integer i : map.keySet()) {
            resultList.add(Arrays.asList(i, map.get(i)));
        }

        return resultList;
    }
}
// @lc code=end

