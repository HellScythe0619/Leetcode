/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
     * runtime: 100% (0 ms)
     * memory: 99.22% (40.5 MB)
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        /**
         * Reverse ListNode
         * 需要有 PrevNode -> CurrNode -> NextNode 模板
         */
        ListNode result = new ListNode(0);
        // 將 result.next 作為 head，也就是 輸出結果
        result.next = head;
        // 當前 result 即為 head 的 prevNode，由此作為 prevNode 起點
        ListNode prevNode = result;
        
        // 到 left 前一個 Node
        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
        }

        // prevNode.next 即首位須置換的 currNode
        ListNode currNode = prevNode.next;

        // right - left 為 總共要置換的 Node 數
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }

        return result.next;
    }
}
// @lc code=end

