/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start

import java.util.HashMap;

/**
 * 使用 Trie Tree (字典樹)
 */
class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        // 該word最底部，判斷此處為一個完整的word
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    /**
     * 使用遞迴方式，判斷該word是否search到
     * @param root2
     * @param word
     * @param i
     * @return
     */
    private boolean searchHelper(TrieNode node, String word, int index) {
        // 若已找到符合word長度的node，則視為此次查詢word的最底部，回傳isWord。
        // 若index為0，則isWord必為false
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            // 若當前search word char為'.'，則for loop判斷當前階層的所有的字元。
            for (TrieNode child : node.children.values()) {
                if (searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) {
                return false;
            }

            return searchHelper(child, word, index + 1);
        }
    }
}

/**
 * 使用 HashMap 方法
 * Time Limit Exceeded
 */
// class WordDictionary {

//     HashMap<Integer, HashSet<String>> wordMap = new HashMap<>();

//     public WordDictionary() {
        
//     }
    
//     public void addWord(String word) {
//         int length = word.length();
//         HashSet<String> wordSet = wordMap.get(length);
//         if (wordSet == null) {
//             wordSet = new HashSet<>();
//         }
//         wordSet.add(word);
//         wordMap.put(length, wordSet);
//     }
    
//     public boolean search(String word) {
//         int length = word.length();
//         char[] wordCharArr = word.toCharArray();
        
//         HashSet<String> wordSet = wordMap.get(length);
//         if (wordSet != null) {
//             for (String temp : wordSet) {
//                 boolean check = true;
//                 char[] tempCharArr = temp.toCharArray();
//                 for (int i = 0; i < tempCharArr.length; i++) {
//                     if (wordCharArr[i] == '.') {
//                         continue;
//                     }

//                     if (tempCharArr[i] != wordCharArr[i]) {
//                         check = false;
//                         break;
//                     }
//                 }

//                 if (check) {
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

