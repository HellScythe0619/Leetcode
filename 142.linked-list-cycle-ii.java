/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 龜兔賽跑
     * Floyd Cycle Detection Algorithm 
     * Time complexity: O(1)
     * Space complexity: O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // slow + 1
            fast = fast.next.next; // fast + 2

            // meet
            if (slow == fast) {
                slow = head;
                // find the cycle pos
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        // not meet
        return null;
    }
}
// @lc code=end

