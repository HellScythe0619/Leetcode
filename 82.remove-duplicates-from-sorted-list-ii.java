/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
     * runtime: 18.95% (1 ms)
     * memory: 73.09% (43 MB)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode temp = result;

        while (head != null) {
            // 判斷當前node和下一個node是否重複
            if (head.next != null && head.val == head.next.val) {
                // 使用while loop找到下一個不重複的node (即 head.next)
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // 接上不重複的node片段
                temp.next = head.next;
            } else {
                // 移動至下一個node
                temp = temp.next;
            }
            // 接續下一個node判斷
            head = head.next;
        }

        return result.next;
    }
}
// @lc code=end

