/*
 * @lc app=leetcode id=2032 lang=java
 *
 * [2032] Two Out of Three
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // /**
    //  * 此為 高效解法 O(n + m + k)
    //  * @param nums1
    //  * @param nums2
    //  * @param nums3
    //  * @return
    //  */
    // public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

    //     // 目標為 三個Array 取至少兩個 同時存在的數字，結果可以不用排序。
    //     List<Integer> result = new ArrayList<>();

    //     // 第一個 num Array 的 HashSet 集合
    //     Set<Integer> numOneSet = new HashSet<>();
    //     for (int num : nums1) {
    //         numOneSet.add(num);
    //     }

    //     // 第二個 num Array 的 HashSet 集合
    //     Set<Integer> numTwoSet = new HashSet<>();
    //     for (int num : nums2) {
    //         /**
    //          * 作成第二個 HashSet 集合前，先看有沒有存在於 第一個HashSet集合，如果有即符合條件
    //          * 判斷 不包含第二個HashSet集合，即是預防重複加入數字
    //          */
    //         if (numOneSet.contains(num) && !numTwoSet.contains(num)) {
    //             result.add(num);
    //         }
    //         // 上述判斷完後才加入 第二個 HashSet 集合
    //         numTwoSet.add(num);
    //     }

    //     // 取第三個 num Array
    //     for (int num : nums3) {
    //         /**
    //          * 不存在於 result Array，但同時存在 第一個HashSet集合 or 第二個HashSet集合，即 nums1 match nums3 or nums2 match nums3
    //          */
    //         if (!result.contains(num) && (numOneSet.contains(num) || numTwoSet.contains(num))) {
    //             result.add(num);
    //         }
    //     }

    //     return result;
    // }

    /**
     * 普通解法
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        // 第一個 num Array 的 HashSet 集合
        Set<Integer> numOneSet = new HashSet<>();
        for (int num : nums1) {
            numOneSet.add(num);
        }

        // 第二個 num Array 的 HashSet 集合
        Set<Integer> numTwoSet = new HashSet<>();
        for (int num : nums2) {
            numTwoSet.add(num);
        }

        // 第二個 num Array 的 HashSet 集合
        Set<Integer> numThreeSet = new HashSet<>();
        for (int num : nums3) {
            numThreeSet.add(num);
        }

        // 目標為 三個Array 取至少兩個 同時存在的數字，結果可以不用排序。
        Set<Integer> resultSet = new HashSet<>();
        for (int num : numOneSet) {
            if (numTwoSet.contains(num) || numThreeSet.contains(num)) {
                resultSet.add(num);
            }
        }
        for (int num : numTwoSet) {
            if (numThreeSet.contains(num)) {
                resultSet.add(num);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
// @lc code=end

