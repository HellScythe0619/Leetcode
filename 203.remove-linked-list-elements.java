/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
     * runtime: 92.62% (1 ms)
     * memory: 52.7% (45.4 MB)
     * @param head
     * @param val
     * @return
     */
    // public ListNode removeElements(ListNode head, int val) {
    //     ListNode result = new ListNode(0);
    //     ListNode temp = result;
    //     result.next = head;

    //     while (temp.next != null) {
    //         if (temp.next.val == val) {
    //             temp.next = temp.next.next;
    //         } else {
    //             temp = temp.next;
    //         }
    //     }

    //     return result.next;
    // }

    /**
     * Recursive Solution (遞迴)
     * runtime: 100% (0 ms)
     * memory: 20.31% (45.6 MB)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
// @lc code=end

