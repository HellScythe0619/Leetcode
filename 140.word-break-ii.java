/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * Time Complexity: O(N^3 + M)
     * Space Complexity: O(N^2 + N * K)
     * N: the length of String s
     * M: the number of List<String> wordDict
     * K: the average length of word in List<String> wordDict
     * 
     * runtime: 91.51% (1 ms)
     * memory: 85.8% (41.4 MB)
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        Map<String, List<String>> memoMap = new HashMap<>();

        return backtrack(s, wordSet, memoMap);
    }

    private List<String> backtrack(String str, Set<String> wordSet, Map<String, List<String>> memoMap) {
        List<String> breaks = new ArrayList<>();

        // memoMap有找到str對應的List<String>，代表此str分割字串為重複字，則回傳。
        if (memoMap.containsKey(str)) {
            return memoMap.get(str);
        }

        // recursive 結束點: 當recursive接收到的str為空字串，代表到底了。
        if (str.isEmpty()) {
            breaks.add("");
            return breaks;
        }

        for (int i = 1; i <= str.length(); i++) {
            /**
             * 取當前str片段判斷是否在wordDict中，有的話則進而recursive。
             * Example: "hamburger".substring(4, 8) returns "urge"
             */
            String prefix = str.substring(0, i);
            if (wordSet.contains(prefix)) {
                /**
                 * 取str prefix後綴的substring成suffix
                 * Example: "unhappy".substring(2) returns "happy"
                 */
                String suffix = str.substring(i);
                // 透過substring的方式，分割string成suffix用recursive找對應的word。
                List<String> resultList = backtrack(suffix, wordSet, memoMap);

                // 將取得的所有字串組合
                for (String suf : resultList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prefix);
                    sb.append(suf.isEmpty() ? "" : " ");
                    sb.append(suf);
                    breaks.add(sb.toString());
                }
            }
        }
        
        memoMap.put(str, breaks);

        return breaks;
    }
}
// @lc code=end

