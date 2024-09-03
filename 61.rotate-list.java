/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        k = k % length;
        k = length - k;

        /**
         * example: length = 5, k = 2
         * k = k % length = 2 % 5 = 2
         * k = 5 - 2 = 3
         * 1 2 3 4 [5]. 1 2 3 4 5. 1 2 3 4 5 ... (circle loop)
         * 1 2 3 4 5. 1 2 [3] 4 5. 1 2 3 4 5 ...
         * -> 4 5 1 2 [3] / cut -> .next = null
         */
        temp.next = head;
        while (k > 0) {
            temp = temp.next;
            k--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
// @lc code=end

