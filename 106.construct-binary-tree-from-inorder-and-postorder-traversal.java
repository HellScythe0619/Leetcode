/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */

// @lc code=start

import java.util.HashMap;

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
     * Use Postorder and Inorder to construct Binary Tree
     * Preorder: 中 左 右
     * Inorder:  左 中 右
     * Postorder:左 右 中
     * 
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
            HashMap<Integer, Integer> inorderMap) {
        
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int nodeInorderIndex = inorderMap.get(node.val);
        int leftTreeSize = nodeInorderIndex - inStart;
        int rightTreeSize = inEnd - nodeInorderIndex;

        /**
         * 左子樹
         * Postorder [左] 右 中 -> 當前 postEnd 為 中，postStart 為 當前整個樹的起點
         *  start: 以 當前整個樹的起點 postStart 為起點，故 左子樹 的 起點為 postStart
         *  end: 以 當前整個樹的起點 postStart 為起點，故 左子樹 的 終點為 postStart + leftTreeSize - 1 (因為需算起頭的 所以要減一)
         */
        node.left = helper(inorder, inStart, nodeInorderIndex - 1, postorder, postStart, postStart + leftTreeSize - 1,
                inorderMap);
        /**
         * 右子樹
         * Postorder 左 [右] 中 -> 當前 postEnd 為 中
         *  start: 以 中 postEnd 為起點，故 右子樹 的 起點為 postEnd - rightTreeSize
         *  end: 以 中 postEnd 為起點，故 右子樹 的 終點為 postEnd - 1
         */
        node.right = helper(inorder, nodeInorderIndex + 1, inEnd, postorder, postEnd - rightTreeSize, postEnd - 1,
                inorderMap);

        return node;
    }
}
// @lc code=end

