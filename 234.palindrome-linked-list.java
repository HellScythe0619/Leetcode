/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
     * Recursive Solution
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 17.4% (14 ms)
     * memory: 5.1% (74.8 MB)
     */
    // ListNode curr;
    // public boolean isPalindrome(ListNode head) {
    //     curr = head;
    //     return helper(head);
    // }

    // private boolean helper(ListNode head) {
    //     if (head == null) {
    //         return true;
    //     }
    //     boolean result = helper(head.next) && head.val == curr.val;
    //     curr = curr.next;
    //     return result;
    // }

    /**
     * ListNode two-pointer slow and fast
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 86.58% (4 ms)
     * memory: 29.91% (68.6 MB)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverseHelper(slow.next);
        slow.next = null;
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverseHelper(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
// @lc code=end
