/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 */

// @lc code=start
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
     * 遞迴解法 recursive solution
     * @param root
     * @return
     */
    // public int countNodes(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     return 1 + countNodes(root.left) + countNodes(root.right);
    // }

    /**
     * DFS function solution
     * @param root
     * @return
     */

    int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDFS(root);
        return count;
    }

    private void getDFS(TreeNode r) {
        if (r == null) {
            return;
        }
        count++;
        getDFS(r.left);
        getDFS(r.right);
    }
}
// @lc code=end

