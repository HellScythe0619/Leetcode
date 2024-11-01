/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    /**
     * Use Trie Tree and HashSet
     * 
     * runtime: 78.65% (137 ms)
     * memory: 90.57% (44.6 MB)
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 建構字典樹
        TrieNode trieTree = buildTrieTree(words);
        HashSet<String> resultSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // DFS backtracking
                dfs(board, i, j, trieTree, resultSet);
            }
        }

        return new ArrayList<>(resultSet);
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode trieNode, HashSet<String> resultSet) {
        // 防呆設計，防止overflow (可刪除)
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        char c = board[i][j];
        // 當前字元已走過 或 該字元不在字典樹軌跡中
        if (c == '#' || trieNode.next[c - 'a'] == null) {
            return;
        }

        // 將字典樹指標移至下一個
        trieNode = trieNode.next[c - 'a'];
        if (trieNode.word != null) {
            resultSet.add(trieNode.word);
            trieNode.word = null; // 去除重複紀錄單字word
        }
        
        board[i][j] = '#';  // 將當前字元標記'#'，防止重複loop走過
        if (i > 0) {
            // 左
            dfs(board, i - 1, j, trieNode, resultSet);
        }
        if (i < board.length - 1) {
            // 右
            dfs(board, i + 1, j, trieNode, resultSet);
        }
        if (j > 0) {
            // 下
            dfs(board, i, j - 1, trieNode, resultSet);
        }
        if (j < board[0].length - 1) {
            // 上
            dfs(board, i, j + 1, trieNode, resultSet);
        }
        board[i][j] = c;    // 還原字元
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    /**
     * 建構 字典樹 TrieTree
     * @param words
     * @return
     */
    public TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();
        // 將單字清單依序輸入至字典樹
        for (String word : words) {
            TrieNode node = root;
            // 將單字拆解字元，將root開枝
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.word = word;
        }
        return root;
    }

}
// @lc code=end

