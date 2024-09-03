/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
     * 使用 Math.max()
     * runtime: 100%
     * memory: 15.93% (42.9MB)
     * @param root
     * @return
     */
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    // }

    /**
     * 不使用 Math.max()
     * runtime: 100%
     * memory: 46.26% (42.6MB)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return 1 + (maxLeft > maxRight ? maxLeft : maxRight);
    }
}
// @lc code=end

