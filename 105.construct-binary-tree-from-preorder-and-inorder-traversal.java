/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
     * Use Preorder and Inorder to construct Binary Tree
     * Preorder: 中 左 右
     * Inorder:  左 中 右
     * Postorder:左 右 中
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 96.83% (1 ms)
     * memory: 22.25% (44.7 MB)
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, inorderMap);
    }

    /**
     * 用 Preorder(中左右) 從 root 開始建立 tree
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorderMap
     * @return
     */
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd,
            HashMap<Integer, Integer> inorderMap) {
        // System.out.println("inStart: " + inStart + ", inEnd: " + inEnd + ", inStart > inEnd:" + (inStart > inEnd)
        //         + ", preStart: " + preStart + ", preEnd: " + preEnd + ", preStart > preEnd:" + (preStart > preEnd));
        
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        // 建立當前node
        TreeNode node = new TreeNode(preorder[preStart]);

        int nodeInorderIndex = inorderMap.get(node.val);
        // 由於 Inorder 是 左中右，所以可以知道node.left總共有多少node
        int leftTreeSize = nodeInorderIndex - inStart;

        /**
         * Recursive 遞迴尋找當前node左子樹
         * node是當前root
         * Inorder(左中右): 
         *  start: inStart維持
         *  end: nodeInorderIndex-1即是Inorder最大的左子樹index
         * Preorder(中左右): 
         *  start: 遞延，即preStart+1
         *  end: preStart+leftTreeSize
         */
        node.left = helper(inorder, inStart, nodeInorderIndex - 1, preorder, preStart + 1, preStart + leftTreeSize,
                inorderMap);
        
        /**
         * Recursive 遞迴尋找當前node右子樹
         */
        node.right = helper(inorder, nodeInorderIndex + 1, inEnd, preorder, preStart + leftTreeSize + 1, preEnd,
                inorderMap);

        // System.out.println("node: " + (node != null ? node.val : "null") + ", node.left: "
        //         + (node.left != null ? node.left.val : "null") + ", node.right: "
        //         + (node.right != null ? node.right.val : "null"));

        /**
         * inStart: 0, inEnd: 4, inStart > inEnd:false, preStart: 0, preEnd: 4, preStart > preEnd:false
         * inStart: 0, inEnd: 0, inStart > inEnd:false, preStart: 1, preEnd: 1, preStart > preEnd:false
         * inStart: 0, inEnd: -1, inStart > inEnd:true, preStart: 2, preEnd: 1, preStart > preEnd:true
         * inStart: 1, inEnd: 0, inStart > inEnd:true, preStart: 2, preEnd: 1, preStart > preEnd:true
         * node: 9, node.left: null, node.right: null
         * inStart: 2, inEnd: 4, inStart > inEnd:false, preStart: 2, preEnd: 4, preStart > preEnd:false
         * inStart: 2, inEnd: 2, inStart > inEnd:false, preStart: 3, preEnd: 3, preStart > preEnd:false
         * inStart: 2, inEnd: 1, inStart > inEnd:true, preStart: 4, preEnd: 3, preStart > preEnd:true
         * inStart: 3, inEnd: 2, inStart > inEnd:true, preStart: 4, preEnd: 3, preStart > preEnd:true
         * node: 15, node.left: null, node.right: null
         * inStart: 4, inEnd: 4, inStart > inEnd:false, preStart: 4, preEnd: 4, preStart > preEnd:false
         * inStart: 4, inEnd: 3, inStart > inEnd:true, preStart: 5, preEnd: 4, preStart > preEnd:true
         * inStart: 5, inEnd: 4, inStart > inEnd:true, preStart: 5, preEnd: 4, preStart > preEnd:true
         * node: 7, node.left: null, node.right: null
         * node: 20, node.left: 15, node.right: 7
         * node: 3, node.left: 9, node.right: 20
         * [3,9,20,null,null,15,7]
         */

        return node;
    }

}
// @lc code=end

