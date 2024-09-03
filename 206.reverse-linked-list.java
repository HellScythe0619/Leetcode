/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 100% (0 ms)
     * memory: 71% (42.2 MB)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode result = null;
        while (head != null) {
            ListNode swap = head.next;
            head.next = result;
            result = head;
            head = swap;
        }

        return result;
    }
}
// @lc code=end

