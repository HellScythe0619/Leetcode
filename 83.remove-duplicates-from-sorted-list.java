/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
     * Own way
     * runtime: 6.94%
     * memory: 6.47% (45.2MB)
     * @param head
     * @return
     */
    // public ListNode deleteDuplicates(ListNode head) {
    //     ListNode result = head;
    //     ListNode temp = result;
    //     if (head != null) {
    //         while (head.next != null) {
    //             int nowVal = head.val;
    //             int nextVal = head.next.val;
    //             System.out.println("nowVal: " + nowVal + ", nextVal: " + nextVal);
    //             if (nowVal != nextVal) {
    //                 System.out.println("temp.next: " + temp.next + ", head.next: " + head.next);
    //                 temp.next = head.next;
    //                 temp = temp.next;
    //             }
    //             head = head.next;
    //         }
    //         temp.next = null;
    //     }
    //     return result;
    // }

    /**
     * leetcode way
     * runtime: 100%
     * memory: 90.3% (43.7MB)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
// @lc code=end

