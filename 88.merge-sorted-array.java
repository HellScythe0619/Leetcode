/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    /**
     * 倒序塞入值，以最大值為優先塞入。
     * runtime: 100%
     * memory: 26.86% (42.3MB)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int size = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[size] = nums1[i];
                i--;
            } else {
                nums1[size] = nums2[j];
                j--;
            }
            size--;
        }

    }
}
// @lc code=end

