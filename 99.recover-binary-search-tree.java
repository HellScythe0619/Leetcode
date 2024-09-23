/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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

    TreeNode smallNode = null;
    TreeNode bigNode = null;
    TreeNode prevNode = null;

    /**
     * Use Inorder to find two node to swap
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (1 ms)
     * memory: 21.82% (44.7 MB)
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inorder(root);
        /**
         * 只會有2個需要置換的node，
         * 故 inorder 完後swap smallNode 和 bigNode
         */
        int temp = smallNode.val;
        smallNode.val = bigNode.val;
        bigNode.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Inorder 左中右 故先左
        inorder(node.left);

        // 因為是 Inorder 左中右掃描，prevNode 必須比當前 node 小
        if (prevNode != null && prevNode.val > node.val) {
            smallNode = node;
            if (bigNode != null) {
                return;
            }
            bigNode = prevNode;
        }
        prevNode = node;

        inorder(node.right);
    }

}
// @lc code=end

