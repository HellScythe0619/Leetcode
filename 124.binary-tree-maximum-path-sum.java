/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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

    // 因為 int 用代入 function 方式的話，無法在 recursive function 傳遞值，故在外定義。
    int maxSum;
    
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 100% (0 ms)
     * memory: 100% (43.1 MB)
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);

        return maxSum;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 計算當前 node 左子樹一條線的最大值
        int leftSum = Math.max(0, helper(node.left));
        // 計算當前 node 右子樹一條線的最大值
        int rightSum = Math.max(0, helper(node.right));
        // 更新最大值，把 左右子樹最大值+當前 node 值 做比較
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
        // 回傳當前node的最大值，取左右子樹其中最大的一條路線
        return node.val + Math.max(leftSum, rightSum);
    }

}
// @lc code=end

