/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * 使用Stack倒序搜尋 O(n)
     * runtime: 67.05%
     * memory: 31.29% (45.6 MB)
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        // 初次篩選
        for (char c : num.toCharArray()) {
            // stack 不為空，且 k 大於0，且 當前stack數字 > c
            while (!stack.empty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 二次篩選，如果k>0，則由後至前依序刪除
        while (k > 0 && !stack.empty()) {
            stack.pop();
            k--;
        }

        // 輸出字串
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        // 因為為倒序，需倒回來
        sb.reverse();

        int startIndex = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.toString().charAt(i) != '0') {
                break;
            }
            startIndex++;
        }

        return sb.length() == startIndex ? "0" : sb.substring(startIndex);
    }
}
// @lc code=end

