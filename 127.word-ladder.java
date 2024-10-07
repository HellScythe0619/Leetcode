/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    /**
     * Use BFS (by Queue) to find result sequence and return the length of sequence
     * 使用 BFS Queue 遍歷 wordList (使用 wordSet 儲存，方便比對 newWord)
     * Time Complexity: O(N * M)
     * Space Complexity: O(N * M)
     * N: the number of words in wordList
     * M: the length of word (因為 word 長度都一樣，所以不須強調平均)
     * 
     * runtime: 68.84% (77 ms)
     * memory: 79.97% (45.9 MB)
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 使用 Set 儲存 wordList 的 words，方便之後隨 for loop 新生成的 newWord 可以快速比對
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        /**
         * 使用 isPresent 快速判斷是否有 endWord 存在 wordList 中
         */
        boolean isPresent = false;
        for (String word : wordList) {
            // 判斷結尾單字 endWord 是否有在 wordList 裡面
            if (endWord.equals(word)) {
                isPresent = true;
                break;
            }
        }

        // if (!wordSet.contains(endWord)) {
        //     return 0;
        // }

        // 在 wordList 找不到 endWord，故肯定不能找出結果 no such sequence exists
        if (!isPresent) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        // 將 beginWord 先加入 queue
        queue.offer(beginWord);

        int distance = 0;

        // 開始 BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            // beginWord 佔一個位置
            distance++;

            while (size-- > 0) {
                // 將當前 Queue pool 最前面的 word 導出
                String currWord = queue.poll();

                // 地毯式找與當前 currWord 差一個 英文字母 的單字
                for (int i = 0; i < currWord.length(); i++) {
                    char[] temp = currWord.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        // 將當前單字格替換英文字母，並轉成新的 newWord
                        temp[i] = c;
                        String newWord = new String(temp);

                        // 若 newWord 剛好等於 endWord，代表找到終點
                        if (newWord.equals(endWord)) {
                            return distance + 1;
                        }

                        // 新生成的 newWord 符合 wordList 裡面其中一個單字
                        if (wordSet.contains(newWord)) {
                            // Queue 新增下一個節點
                            queue.offer(newWord);
                            // Set 移除被找到的 word，防止重複找到
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }

        // 雖然 endWord 有在 wordList，但透過 BFS 找不到對應結果 no such sequence exists
        return 0;
    }
}
// @lc code=end

