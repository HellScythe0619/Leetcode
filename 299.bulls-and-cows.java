/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    /**
     * 幾A幾B，String 比對
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 90.91% (4 ms)
     * memory: 45.82% (42.4 MB)
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        HashMap<Character, Integer> guessMap = new HashMap<>();

        int bullCount = 0;  // A count
        int cowCount = 0;   // B count
        /**
         * secret: 1122 , guess: 1222  -> 3A0B
         * secret: 11222, guess: 12221 -> 3A2B
         * secret: 1234 , guess: 1235  -> 3A0B
         * secret: 1234 , guess: 1345  -> 1A2B
         * secret: 1212 , guess: 2121  -> 0A4B
         */

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
            } else {
                // 紀錄當前數字的失敗次數
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        // 兩個Map比對是否有相同的數字，並取兩者的最小次數
        for (char c : secretMap.keySet()) {
            if (guessMap.containsKey(c)) {
                cowCount += Math.min(secretMap.get(c), guessMap.get(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bullCount).append("A").append(cowCount).append("B");

        return sb.toString();
    }
}
// @lc code=end

