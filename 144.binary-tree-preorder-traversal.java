/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
     * Preorder: 中左右
     * runtime: 100%
     * memory: 85.12% (41.2 MB)
     * @param root
     * @return
     */
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return new ArrayList<>();
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     result.add(root.val);
    //     result.addAll(preorderTraversal(root.left));
    //     result.addAll(preorderTraversal(root.right));
    //     return result;
    // }

    /**
     * runtime: 100%
     * memory: 92.04% (41.2 MB)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        preorderTree(result, root);
        return result;
    }

    private void preorderTree(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderTree(result, node.left);
        preorderTree(result, node.right);
    }

}
// @lc code=end

