/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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

    List<String> resultList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            getDfsLeafNode(root, new StringBuilder());
        }
        return resultList;
    }

    private void getDfsLeafNode(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left != null && node.right != null) {
            // 左右Leaf都有值，需拆開兩支路線。
            getSplitPath(node, sb);
        } else if (node.left != null && node.right == null) {
            // 只有左Leaf有值
            getDfsLeafNode(node.left, sb.append("->"));
        } else if (node.left == null && node.right != null) {
            // 只有右Leaf有值
            getDfsLeafNode(node.right, sb.append("->"));
        } else {
            // 左右Leaf都沒值，代表最底，故輸出該路線。
            resultList.add(sb.toString());
        }
    }

    private void getSplitPath(TreeNode node, StringBuilder sb) {
        sb.append("->");
        getDfsLeafNode(node.left, new StringBuilder(sb.toString()));
        getDfsLeafNode(node.right, new StringBuilder(sb.toString()));
    }
}
// @lc code=end

