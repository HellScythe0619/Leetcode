/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     * N: the length of ListNode headA
     * M: the length of ListNode headB
     * 
     * runtime: 99.87% (1 ms)
     * memory: 27.25% (48.7 MB)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;

        /**
         * 如果 tempA 和 tempB 途中沒有交會點，則 交會點會是彼此的尾端null，即 null==null
         * 如果 tempA 和 tempB 途中有交會點，則會 tempA == tempB，輸出結果
         * 如果 tempA 和 tempB 不同長度，則會有一個先為null，就會接到另一個，透過最多 N+M 次迴圈，輸出結果
         */
        while (tempA != tempB) {
            // 如果 tempA 跑到尾端null，則會接到 headB
            tempA = tempA == null ? headB : tempA.next;
            // 如果 tempB 跑到尾端null，則會接到 headA
            tempB = tempB == null ? headA : tempB.next;
        }
        
        return tempA;
    }
}
// @lc code=end

