/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * Use Arrays.sort()
     * Time Complexity: O(N * N log N)
     * Space Complexity: O(N)
     * 
     * runtime: 97.76% (6 ms)
     * memory: 69.7% (47.6 MB)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> resultList = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            List<String> list = map.getOrDefault(String.valueOf(temp), new ArrayList<>());
            list.add(str);
            map.put(String.valueOf(temp), list);
        }

        // for (List<String> list : map.values()) {
        //     resultList.add(list);
        // }

        // return resultList;
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

