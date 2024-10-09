/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Use Two-pointers and Sliding-window
     * 
     * Time Complexity: O(N + M)
     * Space Complexity: O(N + M)
     * N: the length of String s
     * M: the length of String t
     * 
     * runtime: 66.22% (16 ms)
     * memory: 58.4% (44.8 MB)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 將 target 出現的字元與次數做成 HashMap
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int targetCharsRemaining = t.length();
        // string 最後擷取的結果，預設最左端與最右端
        int[] minWindow = { 0, s.length() };

        // 使用 two-pointers sliding-window 方式求解
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (targetMap.containsKey(c) && targetMap.get(c) > 0) {
                targetCharsRemaining--;
            }
            targetMap.put(c, targetMap.getOrDefault(c, 0) - 1);

            // 找齊target所需的字
            if (targetCharsRemaining == 0) {
                // 在 start 開始從左向右縮小 window 範圍，找到當前的 minWindow
                while (true) {
                    char charStart = s.charAt(start);
                    // 找到符合 target 的字元，即 minWindow 最左，就跳出迴圈
                    if (targetMap.containsKey(charStart) && targetMap.get(charStart) == 0) {
                        break;
                    }
                    // 將原先找到的target字元復原足跡
                    targetMap.put(charStart, targetMap.getOrDefault(charStart, 0) + 1);
                    // 沒找到 minWindow 最左，故持續往右縮編
                    start++;
                }

                /**
                 * 若當前選取的範圍小於 minWindow
                 * 代表找到更小範圍的 minWindow
                 * 則更新 minWindow 以當前範圍 start 到 end 
                 */
                if (end - start < minWindow[1] - minWindow[0]) {
                    minWindow[0] = start;
                    minWindow[1] = end;
                }

                // 因為要找下一位字元，還原當前 index start 字元對應的 targetMap
                targetMap.put(s.charAt(start), targetMap.getOrDefault(s.charAt(start), 0) + 1);
                targetCharsRemaining++;
                start++;
            }
        }

        /**
         * 若 minWindow[1]，即搜尋到的 minWindow 最右端超出 string 範圍，則代表無結果，輸出 ""，
         * 否則輸出 substring，注意最右端需要 minWindow[1] + 1，否則少一位
         */
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}
// @lc code=end

