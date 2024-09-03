/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * Myself
     * runtime: 100%
     * memory: 75.43% (40.9 MB)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        swapNode(head, true);
        return result.next;
    }

    private void swapNode(ListNode node, boolean doSwap) {
        if (node.next == null) {
            return;
        }

        if (doSwap) {
            doSwap = false;
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
        } else {
            doSwap = true;
        }
        swapNode(node.next, doSwap);
    }
}
// @lc code=end

