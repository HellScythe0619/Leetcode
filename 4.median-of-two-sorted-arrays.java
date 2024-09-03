/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length, n2 = nums2.length;

    //     // Ensure nums1 is the smaller array for simplicity
    //     if (n1 > n2)
    //         return findMedianSortedArrays(nums2, nums1);

    //     int n = n1 + n2;
    //     int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
    //     int low = 0, high = n1;

    //     while (low <= high) {
    //         int mid1 = (low + high) >> 1; // Calculate mid index for nums1
    //         int mid2 = left - mid1; // Calculate mid index for nums2

    //         int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

    //         // Determine values of l1, l2, r1, and r2
    //         if (mid1 < n1)
    //             r1 = nums1[mid1];
    //         if (mid2 < n2)
    //             r2 = nums2[mid2];
    //         if (mid1 - 1 >= 0)
    //             l1 = nums1[mid1 - 1];
    //         if (mid2 - 1 >= 0)
    //             l2 = nums2[mid2 - 1];

    //         if (l1 <= r2 && l2 <= r1) {
    //             // The partition is correct, we found the median
    //             if (n % 2 == 1)
    //                 return Math.max(l1, l2);
    //             else
    //                 return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
    //         }
    //         else if (l1 > r2) {
    //             // Move towards the left side of nums1
    //             high = mid1 - 1;
    //         }
    //         else {
    //             // Move towards the right side of nums1
    //             low = mid1 + 1;
    //         }
    //     }

    //     return 0; // If the code reaches here, the input arrays were not sorted.
    // }

    /**
     * Two pointer
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        // 須讓 nums1 Array 較短
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;

        int low = 0;
        int high = len1;
        while (low <= high) {
            int nums1Partition = (low + high) / 2;
            int nums2Partition = (len1 + len2 + 1) / 2 - nums1Partition;
            int maxLeftNums1 = (nums1Partition == 0) ? Integer.MIN_VALUE : nums1[nums1Partition - 1];
            int minRightNums1 = (nums1Partition == len1) ? Integer.MAX_VALUE : nums1[nums1Partition];

            int maxLeftNums2 = (nums2Partition == 0) ? Integer.MIN_VALUE : nums2[nums2Partition - 1];
            int minRightNums2 = (nums2Partition == len2) ? Integer.MAX_VALUE : nums2[nums2Partition];

            if (maxLeftNums2 > minRightNums1) {
                low = nums1Partition + 1;
            } else if (maxLeftNums1 > minRightNums2) {
                high = nums1Partition - 1;
            } else if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                // 總長度為偶數，需取兩數平均值
                if ((len1 + len2) % 2 == 0) {
                    return ((double) Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
                } else {
                    return (double) Math.max(maxLeftNums1, maxLeftNums2);
                }
            }
        }
        return 0.0;
    }
}
// @lc code=end

