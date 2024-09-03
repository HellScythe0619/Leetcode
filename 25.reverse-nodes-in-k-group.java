/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
     * reverse linked list node
     * runtime: 100%
     * memory: 67.04% (44.1 MB)
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode prev = result;
        ListNode curr = head;
        while (curr != null) {

            ListNode start = prev.next;
            ListNode end = curr;
            int count = 0;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }

            if (count == k) {
                ListNode nextStart = end;
                ListNode reversedListNode = reverseNode(start, k);

                prev.next = reversedListNode;
                start.next = nextStart;

                prev = start;
                curr = nextStart;
            } else {
                break;
            }
        }

        return result.next;
    }

    private ListNode reverseNode(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        return prev;
    }

    // public class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }
}
// @lc code=end

