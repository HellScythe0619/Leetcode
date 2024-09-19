/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
     * runtime: 100% (0 ms)
     * memory: 64.08% (43.2 MB)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        /**
         * min max 範圍取Long極端值 (超過Integer極端值)
         */
        return validHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validHelper(TreeNode node, long min, long max) {
        // 最底的 child 一定回傳 true
        if (node == null) {
            return true;
        }

        // 找到 false 條件即可
        if (!(node.val > min && node.val < max)) {
            return false;
        }

        /**
         * left child:
         *  min 不設限
         *  max 當前 node.val
         * right child:
         *  min 當前 node.val
         *  max 不設限
         */
        return validHelper(node.left, min, node.val) && validHelper(node.right, node.val, max);
    }

}
// @lc code=end

