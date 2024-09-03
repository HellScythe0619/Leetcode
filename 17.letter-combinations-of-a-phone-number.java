/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * DFS recursive
     * runtime: 67.98%
     * memory: 75.52% (41.9 MB)
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        Map<Character, List<String>> digitMap = new HashMap<>();
        digitMap.put('2', Arrays.asList(new String[] { "a", "b", "c" }));
        digitMap.put('3', Arrays.asList(new String[] { "d", "e", "f" }));
        digitMap.put('4', Arrays.asList(new String[] { "g", "h", "i" }));
        digitMap.put('5', Arrays.asList(new String[] { "j", "k", "l" }));
        digitMap.put('6', Arrays.asList(new String[] { "m", "n", "o" }));
        digitMap.put('7', Arrays.asList(new String[] { "p", "q", "r", "s" }));
        digitMap.put('8', Arrays.asList(new String[] { "t", "u", "v" }));
        digitMap.put('9', Arrays.asList(new String[] { "w", "x", "y", "z" }));

        letterDFS(new StringBuilder(), result, digitMap, digits, 0);

        return result;
    }

    private void letterDFS(StringBuilder sb, List<String> result, Map<Character, List<String>> digitMap,
            String digits, int index) {
        // 超過長度，故擷取當前結果至result
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        List<String> letterList = digitMap.get(digits.charAt(index));
        for (String letter : letterList) {
            sb.append(letter);
            letterDFS(sb, result, digitMap, digits, index + 1);
            // 防止舊的繼續存在，需移除已使用過的letter
            // ex: ["ad","ade","adef","adefbd","adefbde","adefbdef","adefbdefcd","adefbdefcde","adefbdefcdef"]
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

