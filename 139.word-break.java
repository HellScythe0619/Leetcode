/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

// import java.util.HashMap;
// import java.util.HashSet;
import java.util.List;
// import java.util.Map;
// import java.util.Set;

class Solution {
    /**
     * Dynamic Programming (DP)
     * Time Complexity: O(N * M)
     * Space Complexity: O(N)
     * N: the length of the String s
     * M: the maximum length of a word in the List<String> wordDict
     * 
     * runtime: 98.85% (1 ms)
     * memory: 99.63% (40.9 MB)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        int maxWordLength = 0;
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int i = 1; i < s.length() + 1; ++i) {
            for (int j = i - 1; j >= Math.max(i - maxWordLength - 1, 0); --j) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    /**
     * Depth First Search with Memoization (DFS)
     * Time Complexity: O(N * M + K)
     * Space Complexity: O(N + K)
     * N: the length of String s
     * M: the maximum length of a word in the List<String> wordDict
     * K: the total number of characters in all words in the List<String> wordDict
     * 
     * @param s
     * @param wordDict
     * @return
     */
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Map<String, Boolean> dfsMap = new HashMap<>();
    //     Set<String> wordSet = new HashSet<>(wordDict);

    //     return dfs(s, wordSet, dfsMap);
    // }

    // private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> dfsMap) {
    //     if (dfsMap.containsKey(s)) {
    //         return dfsMap.get(s);
    //     }

    //     if (wordSet.contains(s)) {
    //         return true;
    //     }

    //     for (int i = 1; i < s.length(); ++i) {
    //         String str = s.substring(0, i);
    //         if (wordSet.contains(str) && dfs(s.substring(i), wordSet, dfsMap)) {
    //             dfsMap.put(s, true);
    //             return true;
    //         }
    //     }

    //     dfsMap.put(s, false);
    //     return false;
    // }

}
// @lc code=end

