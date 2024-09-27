/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 調整字串等距至最大數
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N * M)
     * N: the number of words
     * M: the average length of the words
     * 
     * runtime: 64.68% (1 ms)
     * memory: 33.19% (41.9 MB)
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultList = new ArrayList<>();

        // 當前行的單字List
        List<String> currWordList = new ArrayList<>();
        // 當前行總長度
        int currLength = 0;
        for (String word : words) {
            /**
             * word.length(): 當前 單字 word 長度
             * currLength: 當前行總長度
             * currWordList.size(): 單字間所需的空白數
             * 
             * 將當前 currWordList 進行處理並清空，再加入當前的 word 作為新的行
             */
            if (currLength + word.length() + currWordList.size() > maxWidth) {
                int totalSpaces = maxWidth - currLength;
                int wordGaps = currWordList.size() - 1;

                StringBuilder line = new StringBuilder();
                if (wordGaps == 0) {
                    line.append(currWordList.get(0));
                    line.append(this.buildRepeatSpaces(totalSpaces));

                } else {
                    int spacePerGap = totalSpaces / wordGaps;
                    int extraSpaces = totalSpaces % wordGaps;
                    for (int i = 0; i < currWordList.size(); i++) {
                        line.append(currWordList.get(i));
                        if (i < wordGaps) {
                            line.append(this.buildRepeatSpaces(spacePerGap));
                            if (i < extraSpaces) {
                                line.append(" ");
                            }
                        }
                    }
                }
                resultList.add(line.toString());

                currWordList.clear();
                currLength = 0;
            }
            currWordList.add(word);
            currLength += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", currWordList));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        resultList.add(lastLine.toString());

        return resultList;
    }

    private String buildRepeatSpaces(int totalSpaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSpaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
// @lc code=end

