/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start

import java.util.Stack;

class Solution {
    /**
     * Use Stack pop and push
     * runtime: 87.3% (4 ms)
     * memory: 52.43% (43.4 MB)
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] components = path.split("/");

        for (String component : components) {
            /**
             * ""   代表 有重複的 "//" 在 path 中
             * "."  代表 當前資料夾
             */
            if (component.equals("") || component.equals(".")) {
                continue;
            }

            // ".." 代表 回到上一層資料夾，故遇到則 stack.pop()，即抵銷
            if (component.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        // 若 stack 為空，則需要回傳"/"
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        /**
         * for loop stack output 會是FIFO
         * 即最早輸入的String會先輸出顯示
         */
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // while (!stack.isEmpty()) {
        //     sb.append("/").append(stack.pop());
        // }
        
        return sb.toString();
    }
}
// @lc code=end

