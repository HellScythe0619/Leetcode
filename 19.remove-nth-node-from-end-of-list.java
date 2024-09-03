/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
     * O(N)
     * runtime: 100%
     * memory: 20.62% (41.9 MB)
     * @param head
     * @param n
     * @return
     */
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode slow = head;
    //     ListNode fast = head; // 先起跑n個點，代表最終跑到的中斷點

    //     while (n-- > 0) {
    //         fast = fast.next;
    //     }

    //     if (fast == null) {
    //         // 代表ListNode共n個node，但從後數到前n個，即代表刪除第1個node
    //         return head.next;
    //     }

    //     // 迴圈找到slow為要刪除的前一個點
    //     while (fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next;
    //     }
    //     slow.next = slow.next.next;

    //     return head;
    // }
    
    /**
     * 先計算總total，再找到指定index的node刪除 O(N)
     * runtime: 100%
     * memory: 55.73% (41.6 MB)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int totalNode = 0;

        while (temp != null) {
            temp = temp.next;
            totalNode++;
        }

        // 即要刪除的點為第一個點
        if (n == totalNode) {
            return head.next;
        }

        ListNode node = head;
        int index = 1;

        // 找到要刪除的前一個點，並停下
        while (index < totalNode - n) {
            node = node.next;
            index++;
        }
        node.next = node.next.next;
        return head;
    }
    
}
// @lc code=end

