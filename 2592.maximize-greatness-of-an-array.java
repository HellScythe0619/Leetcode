/*
 * @lc app=leetcode id=2592 lang=java
 *
 * [2592] Maximize Greatness of an Array
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    /**
     * 排序後，從最小數開始置換，即可取maximize greatness O(n log n)
     * runtime: 68.45%
     * memory: 28.16% (59.1 MB)
     * @param nums
     * @return
     */
    // public int maximizeGreatness(int[] nums) {
    //     if (nums.length == 1) {
    //         return 0;
    //     }

    //     Arrays.sort(nums);
    //     int curr = 0;
    //     int count = 0;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] > nums[curr]) {
    //             count++;
    //             curr++;
    //         }
    //     }

    //     // [1, 1, 1, 2, 3, 3, 5]
    //     // [2, 3, 3, 5, 1, 1, 1]

    //     return count;
    // }

    /**
     * runtime: 5.34%
     * memory: 94.18% (57.4 MB)
     * @param nums
     * @return
     */
    public int maximizeGreatness(int[] nums) {
        Queue<Integer> minQueue = new PriorityQueue<>();    // 自動排序的Queue
        Queue<Integer> maxQueue = new PriorityQueue<>();    // 自動排序的Queue

        for (int num : nums) {
            minQueue.add(num);
            maxQueue.add(num);
        }

        int count = 0;
        while (!maxQueue.isEmpty()) {
            if (minQueue.peek() < maxQueue.peek()) {
                minQueue.poll();
                count++;
            }
            maxQueue.poll();
        }

        return count;
    }



}
// @lc code=end

