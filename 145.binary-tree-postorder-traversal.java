/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
     * Postorder 左右中
     * runtime: 100%
     * memory: 84.64% (41.2 MB)
     * @param root
     * @return
     */
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     if (root == null) {
    //         return new ArrayList<>();
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     result.addAll(postorderTraversal(root.left));
    //     result.addAll(postorderTraversal(root.right));
    //     result.add(root.val);
    //     return result;
    // }

    /**
     * runtime: 100%
     * memory: 97.91% (40.9 MB)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        postorderTree(result, root);
        return result;
    }

    private void postorderTree(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTree(result, node.left);
        postorderTree(result, node.right);
        result.add(node.val);
    }
}
// @lc code=end

