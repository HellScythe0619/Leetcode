/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
     * Merge Sort
     * Time complexity: O(log n)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        // head 為空 or head 只有一個數，直接輸出 head
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * step 1: 分割成兩個一半長度的 ListNode
         * 使用 Floyd Cycle Detection Algorithm (龜兔賽跑) 判斷方式
         */
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 分割一半
        temp.next = null;

        ListNode node1 = sortList(head); // 前半段
        ListNode node2 = sortList(slow); // 後半段

        // 透過 recursive 遞迴方式，最終拆成各一值merge，再依序回來merge片段，最終完整
        return merge(node1, node2);
    }
    
    /**
     * 依大小合併 兩個片段的 ListNode
     * @param node1
     * @param node2
     * @return
     */
    public ListNode merge(ListNode node1, ListNode node2) {

        ListNode resultListNode = new ListNode(0);
        ListNode tempListNode = resultListNode;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                tempListNode.next = node2;
                node2 = node2.next;
            } else {
                tempListNode.next = node1;
                node1 = node1.next;
            }
            tempListNode = tempListNode.next;
        }

        if (node1 != null) {
            tempListNode.next = node1;
        }

        if (node2 != null) {
            tempListNode.next = node2;
        }
        
        return resultListNode.next; // 拋棄new 預設的0
    }
}
// @lc code=end

