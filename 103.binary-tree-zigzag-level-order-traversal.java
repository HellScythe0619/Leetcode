/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
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
     * Use Queue and Collections.reverse for Zigzag list
     * runtime: 73.39% (8 ms)
     * memory: 42.86% (42.2 MB)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        queue.offer(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            int currLevel = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < currLevel; i++) {
                TreeNode node = queue.peek();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                list.add(node.val);
                queue.poll();
            }

            if (zigzag) {
                Collections.reverse(list);
            }
            
            resultList.add(list);
            zigzag = !zigzag;
        }

        return resultList;
    }
}
// @lc code=end

