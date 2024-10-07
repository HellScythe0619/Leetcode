/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    // /**
    //  * Time Limit Exceeded
    //  * @param beginWord
    //  * @param endWord
    //  * @param wordList
    //  * @return
    //  */
    // public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    //     if (!wordList.contains(endWord)) {
    //         return new ArrayList<>();
    //     }

    //     List<List<String>> resultList = new ArrayList<>();
    //     Set<String> wordSet = new HashSet<>(wordList);
    //     wordSet.add(beginWord);

    //     Map<String, List<String>> wordNeighborMap = new HashMap<>();
    //     Map<String, Integer> distanceMap = new HashMap<>();
    //     this.bfs(beginWord, endWord, wordSet, wordNeighborMap, distanceMap);

    //     List<String> list = new ArrayList<>();
    //     this.dfs(beginWord, endWord, wordNeighborMap, distanceMap, list, resultList);

    //     return resultList;
    // }

    // /**
    //  * BFS 從 beginWord start 找路徑，level by level
    //  * 
    //  * BFS 可以確保 distance of each word is the shortest one
    //  * 因為第一次 visit word 就會更新 distance，
    //  * 故 word 第一次 visit，必定為 the shortest distance，
    //  * 之後 word 再被 visit，因為判斷 distance 不小於 第一次遇到 word 的 distance，
    //  * 所以 distance 不會被 update
    //  * @param beginWord
    //  * @param endWord
    //  * @param wordSet
    //  * @param wordNeighborMap
    //  * @param distanceMap
    //  */
    // private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> wordNeighborMap,
    //         Map<String, Integer> distanceMap) {
    //     for (String word : wordSet) {
    //         wordNeighborMap.put(word, new ArrayList<>());
    //     }

    //     Queue<String> queue = new LinkedList<>();
    //     queue.offer(beginWord);
    //     distanceMap.put(beginWord, 0);

    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         for (int i = 0; i < size; i++) {
    //             String currWord = queue.poll();
    //             int currDistance = distanceMap.get(currWord);
    //             List<String> currWordNeighbors = this.getNeighbors(currWord, wordSet);
    //             for (String neighbor : currWordNeighbors) {
    //                 wordNeighborMap.get(currWord).add(neighbor);
    //                 if (!distanceMap.containsKey(neighbor)) {
    //                     distanceMap.put(neighbor, currDistance + 1);
    //                     if (endWord.equals(neighbor)) {
    //                         break;
    //                     } else {
    //                         queue.offer(neighbor);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }

    // private List<String> getNeighbors(String word, Set<String> wordSet) {
    //     List<String> wordNeighbors = new ArrayList<>();
    //     for (int i = 0; i < word.length(); i++) {
    //         char[] temp = word.toCharArray();
    //         for (char c = 'a'; c <= 'z'; c++) {
    //             temp[i] = c;
    //             String newWord = new String(temp);
    //             if (wordSet.contains(newWord)) {
    //                 wordNeighbors.add(newWord);
    //             }
    //         }
    //     }
    //     return wordNeighbors;
    // }

    // private void dfs(String beginWord, String endWord, Map<String, List<String>> wordNeighborMap,
    //         Map<String, Integer> distanceMap, List<String> list, List<List<String>> resultList) {
    //     list.add(beginWord);
    //     if (endWord.equals(beginWord)) {
    //         resultList.add(new ArrayList<>(list));
    //     } else {
    //         for (String neighbor : wordNeighborMap.get(beginWord)) {
    //             if (distanceMap.get(neighbor) == distanceMap.get(beginWord) + 1) {
    //                 dfs(neighbor, endWord, wordNeighborMap, distanceMap, list, resultList);
    //             }
    //         }
    //     }

    //     list.remove(list.size() - 1);
    // }


    /**
     * 
     * Time Complexity: O(N^2 * M)
     * Space Complexity: O(N^2)
     * 
     * runtime: 14.61% (24 ms)
     * memory: 86.17% (43.2 MB)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // 在 wordList 找不到 endWord，則必定空集合
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        // 將 beginWord 加入到 wordList
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, List<String>> wordNeighborMap = new HashMap<>();
        for (String word : wordList) {
            wordNeighborMap.put(word, new ArrayList<>());
        }

        // 兩兩比對，建立符合每個單字間相鄰差一個字母的List，並依起始單字做成 wordNeighborMap
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if (this.getCharDifferenceCount(word1, word2) == 1) {
                    wordNeighborMap.get(word1).add(word2);
                    wordNeighborMap.get(word2).add(word1);
                }
            }
        }

        List<List<String>> resultList = new ArrayList<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        this.bfsForShortestPathCost(wordNeighborMap, beginWord, endWord, distanceMap);
        List<String> list = new ArrayList<>();
        list.add(endWord);
        this.endToBeginDfs(wordNeighborMap, beginWord, endWord, distanceMap, list, resultList);

        return resultList;
    }
    
    /**
     * 找出單字間字母差異數量
     * @param word1
     * @param word2
     * @return
     */
    private int getCharDifferenceCount(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Use BFS find the shortest path
     * @param wordNeighborMap
     * @param beginWord
     * @param endWord
     * @param distanceMap
     * @return
     */
    private int bfsForShortestPathCost(Map<String, List<String>> wordNeighborMap, String beginWord, String endWord,
            Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        queue.add(beginWord);
        dist.put(beginWord, 1);
        distanceMap.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            int currDistance = dist.get(currWord);

            if (currWord.equals(endWord)) {
                return currDistance;
            }

            for (String neighbor : wordNeighborMap.get(currWord)) {
                if (!dist.containsKey(neighbor)) {
                    dist.put(neighbor, currDistance + 1);
                    queue.add(neighbor);
                    distanceMap.put(neighbor, currDistance + 1);
                }
            }
        }

        return 0;
    }

    /**
     * Use DFS 從 endWord 到 beginWord 建構所有 shortest path
     * @param wordNeighborMap
     * @param beginWord
     * @param endWord
     * @param distanceMap
     * @param list
     * @param resultList
     */
    private void endToBeginDfs(Map<String, List<String>> wordNeighborMap, String beginWord, String endWord,
            Map<String, Integer> distanceMap, List<String> list, List<List<String>> resultList) {
        

        if (endWord.equals(beginWord)) {
            resultList.add(new ArrayList<>(list));
        }


        for (String neighbor : wordNeighborMap.get(endWord)) {
            if (distanceMap.containsKey(neighbor) && distanceMap.get(neighbor) < distanceMap.get(endWord)) {
                list.add(0, neighbor);
                endToBeginDfs(wordNeighborMap, beginWord, neighbor, distanceMap, list, resultList);
                list.remove(0);
            }
        }

    }




}
// @lc code=end

