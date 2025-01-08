/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    /**
     * Use Floyd Cycle Detection Algorithm (龜兔賽跑、判斷環)
     * 可以找到重複的數字，因為重複的數字相當於形成一個環 cycle
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * 
     * runtime: 87.48% (4 ms)
     * memory: 38.74% (58.4 MB)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // 起點
        int fast = nums[0]; // 起點

        while (true) {
            slow = nums[slow]; // 走一步
            fast = nums[nums[fast]]; // 走兩步

            // 判斷形成環
            if (slow == fast) {
                break;
            }
        }
        
        int slow2 = nums[0];
        // 找到重複數字
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
// @lc code=end

