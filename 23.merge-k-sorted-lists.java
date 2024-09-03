/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
     * merge sort
     * runtime: 100%
     * memory: 46.96% (44.4 MB)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode leftNode = mergeList(lists, start, mid);
        ListNode rightNode = mergeList(lists, mid + 1, end);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        if (node1 != null) {
            temp.next = node1;
        } else if (node2 != null) {
            temp.next = node2;
        }

        return result.next;
    }
}
// @lc code=end

