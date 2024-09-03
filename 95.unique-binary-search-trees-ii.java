/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
     * Recursion And Dynamic Programming (DP)
     * Time Complexity: O(C_n)
     * Space Complexity: O(N * C_n)
     * C_n: the n-th Catalan number
     * 
     * runtime: 97.14% (1 ms)
     * memory: 17.92% (44.6 MB)
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateBST(1, n);
    }

    private List<TreeNode> generateBST(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTree = generateBST(start, i - 1);
            List<TreeNode> rightTree = generateBST(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    result.add(currTree);
                }
            }
        }

        return result;
    }
}
// @lc code=end

