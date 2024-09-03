/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 98.64% (2 ms)
     * memory: 32% (45 MB)
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        String checkStr = "aeiouAEIOU";
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (checkStr.indexOf(arr[left]) == -1) {
                left++;
                continue;
            }
            if (checkStr.indexOf(arr[right]) == -1) {
                right--;
                continue;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}
// @lc code=end

