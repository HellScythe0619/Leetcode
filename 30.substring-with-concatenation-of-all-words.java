/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * Time Complexity: O(N * L)
     * Space Complexity: O(M)
     * N: the length of string s
     * L: the length of word in the words array
     * M: the number of words
     * 
     * runtime: 67.61% (26 ms)
     * memory: 18.37% (46.1 MB)
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return resultList;
        }

        int wordLength = words[0].length(); // All the strings of words are of the same length
        int wordCount = words.length;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;

            Map<String, Integer> tempWordMap = new HashMap<>();
            
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                tempWordMap.put(word, tempWordMap.getOrDefault(word, 0) + 1);
                count++;

                if (count == wordCount) {
                    if (wordMap.equals(tempWordMap)) {
                        resultList.add(left);
                    }

                    String remove = s.substring(left, left + wordLength);
                    tempWordMap.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    left += wordLength;
                }
            }
        }

        return resultList;
    }

}
// @lc code=end

