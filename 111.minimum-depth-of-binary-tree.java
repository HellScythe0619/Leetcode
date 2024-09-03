/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 */

// @lc code=start

import java.util.LinkedList;
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
     * 普通 recursive 遞迴解法
     * runtime: 15.7%
     * memory: 24.14% (63.5MB)
     * @param root
     * @return
     */
    // public int minDepth(TreeNode root) {
    //     // 若root為空
    //     if (root == null) {
    //         return 0;
    //     }

    //     return findMinDepth(root);
    // }

    // private int findMinDepth(TreeNode node) {
    //     if (node.left == null && node.right == null) {
    //         // 已經到最底node，左右皆無child
    //         return 1;
    //     } else if (node.left == null) {
    //         // 當前node只有左child
    //         return 1 + findMinDepth(node.right);
    //     } else if (node.right == null) {
    //         // 當前node只有右child
    //         return 1 + findMinDepth(node.left);
    //     }
    //     // 當前node左右皆有child
    //     return 1 + Math.min(findMinDepth(node.left), findMinDepth(node.right));
    // }


    /**
     * DFS
     * runtime: 15.7%
     * memory: 24.14% (63.4MB)
     * @param root
     * @return
     */
    // public int minDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     } else if (root.left == null && root.right == null) {
    //         return 1;
    //     } else if (root.left == null) {
    //         return 1 + minDepth(root.right);
    //     } else if (root.right == null) {
    //         return 1 + minDepth(root.left);
    //     }
    //     return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    // }


    /**
     * BFS
     * runtime: 92.64%
     * memory: 55.57% (63.2MB)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                if (root.left == null && root.right == null) {
                    return depth;
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
// @lc code=end

