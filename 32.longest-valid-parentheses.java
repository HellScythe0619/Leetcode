/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * use Stack
     * runtime: 68.47%
     * memory: 19.36% (43.1 MB)
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maxLength = Math.max(maxLength, i - stack.peek());
            }
        }

        return maxLength;
    }
}
// @lc code=end

