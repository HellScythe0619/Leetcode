/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start

class Solution {
    /**
     * runtime: 27.15%
     * memory: 38.94% (44.6 MB)
     * @param s
     * @return
     */
    // public boolean isPalindrome(String s) {
    //     String str = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    //     if (!str.equals("")) {
    //         int middle = str.length() / 2;
    //         for (int i = 0; i < middle; i++) {
    //             char left = str.charAt(i);
    //             char right = str.charAt(str.length() - i - 1);
    //             if (left != right) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    /**
     * two pointer
     * runtime: 98.9%
     * memory: 66.56% (42.9 MB)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (!s.isEmpty()) {
            int start = 0;
            int end = s.length() - 1;
            while (start <= end) {
                char left = s.charAt(start);
                char right = s.charAt(end);
                if (!Character.isLetterOrDigit(left)) {
                    start++;
                } else if (!Character.isLetterOrDigit(right)) {
                    end--;
                } else {
                    if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}
// @lc code=end

