/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * Myself 17 ms O(N^2)
     * runtime: 17.74%
     * memory: 11.32% (43.5 MB)
     * @param nums
     * @param target
     * @return
     */
    // public int threeSumClosest(int[] nums, int target) {
    //     int distance = Integer.MAX_VALUE;
    //     int result = 0;

    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length; i++) {
    //         int left = i + 1;
    //         int right = nums.length - 1;
    //         while (left < right) {
    //             int sum = nums[i] + nums[left] + nums[right];
    //             int dis = Math.abs(sum - target);
    //             if (sum == target) {
    //                 result = sum;
    //                 break;
    //             } else if (sum < target) {
    //                 if (dis < distance) {
    //                     result = sum;
    //                     distance = dis;
    //                 }
    //                 left++;
    //             } else {
    //                 if (dis < distance) {
    //                     result = sum;
    //                     distance = dis;
    //                 }
    //                 right--;
    //             }
    //         }
    //     }

    //     return result;
    // }

    
    /**
     * O(N^2)
     * runtime: 34.3%
     * memory: 76.12% (42.9 MB)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

}
// @lc code=end

