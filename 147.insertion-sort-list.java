/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Linked List sort swap node
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 63.3% (18 ms)
     * memory: 17.45% (44.8 MB)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(0);

        ListNode curr = head;
        ListNode prev = result;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;

            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;
            prev = result;
            curr = next;
        }

        return result.next;
    }
}
// @lc code=end
