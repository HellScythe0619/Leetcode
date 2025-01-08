/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
     * Use slow-fast way to find the middle of Linked List
     * Reverse Linked List and Merge two parts of Linked List
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * 
     * runtime: 87.71% (2 ms)
     * memory: 81.23% (47.9 MB)
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 使用快慢法找到中間的ListNode -> slow
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反轉後半段的Linked List -> prev
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // 將兩段 Linked List 合併
        ListNode first = head;  // 前半
        ListNode second = prev; // 後半
        while (second.next != null) {
            ListNode node1 = first.next;
            ListNode node2 = second.next;

            first.next = second;
            first = node1;

            second.next = first;
            second = node2;
        }
    }
}
// @lc code=end

