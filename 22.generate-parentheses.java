/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * recursive
     * runtime: 84.6%
     * memory: 92.22% (42.5 MB)
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        parenthesis(result, sb, 0, 0, n);
        return result;
    }

    private void parenthesis(List<String> result, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append('(');
            parenthesis(result, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(')');
            parenthesis(result, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

