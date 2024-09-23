/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 使用 Queue 抓取各 Level 的 node
     * runtime: 90.85% (1ms)
     * memory: 77.14% (44.7 MB)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        /**
         * Queue add() 和 offer() 都是添加一個元素
         * 但當容量滿的時候，
         *  add() 會 throw IllegalStateException
         *  offer() 只會返回 false
         * 故使用 offer() 比較安全 
         */
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 取得當前level有幾個node
            int currLevel = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < currLevel; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                /**
                 * 將 queue 當前的 node 導出，並取其 val 存入 list
                 */
                list.add(node.val);
                queue.poll();
                // list.add(queue.poll().val);
            }

            resultList.add(list);
        }
        
        return resultList;
    }
}
// @lc code=end

