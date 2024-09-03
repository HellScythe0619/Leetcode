/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class Solution {
    /**
     * Use no loop
     * runtime: 30.11% (2 ms)
     * memory: 51.77% (41.8 MB)
     * @param word
     * @return
     */
    // public boolean detectCapitalUse(String word) {
    //     if (word.equals(word.toUpperCase())) {
    //         return true;
    //     }

    //     if (word.equals(word.toLowerCase())) {
    //         return true;
    //     }

    //     if (Character.isUpperCase(word.charAt(0))) {
    //         String subStr = word.substring(1);
    //         if (subStr.equals(subStr.toLowerCase())) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    /**
     * runtime: 88.25% (1 ms)
     * memory: 5.49% (42.3 MB)
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        boolean allUpperCase = false;
        boolean allLowerCase = false;
        boolean firstUpperCase = false;

        if (word.charAt(0) >= 65 && word.charAt(0) <= 90) {
            if (word.length() > 1 && word.charAt(1) >= 65 && word.charAt(1) <= 90) {
                allUpperCase = true;
            } else {
                firstUpperCase = true;
            }
        } else {
            allLowerCase = true;
        }

        /**
         * A: 65, Z: 90
         * a: 97, z: 122
         */
        for (int i = 1; i < word.length(); i++) {
            if (allUpperCase && (word.charAt(i) < 65 || word.charAt(i) > 90)) {
                return false;
            }
            if (allLowerCase && (word.charAt(i) < 97 || word.charAt(i) > 122)) {
                return false;
            }
            if (firstUpperCase && (word.charAt(i) < 97 || word.charAt(i) > 122)) {
                return false;
            }
        }

        return true;
    }

}
// @lc code=end

