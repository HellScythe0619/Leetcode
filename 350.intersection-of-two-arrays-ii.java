/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int numOnePointer = 0;
        int numTwoPointer = 0;
        int index = 0;

        List<Integer> resultList = new ArrayList<>();
        // int[] resultArray = new int[Math.min(nums1.length, nums2.length)];

        while (numOnePointer < nums1.length && numTwoPointer < nums2.length) {
            if (nums1[numOnePointer] < nums2[numTwoPointer]) {
                numOnePointer++;
            } else if (nums1[numOnePointer] > nums2[numTwoPointer]) {
                numTwoPointer++;
            } else {
                // resultArray[index++] = nums1[numOnePointer];
                resultList.add(nums1[numOnePointer]);
                numOnePointer++;
                numTwoPointer++;
            }
        }
        // return Arrays.copyOfRange(resultArray, 0, index);
        int[] resultArray = new int[resultList.size()];
        for (int num : resultList) {
            resultArray[index++] = num;
        }
        // return resultList.stream().mapToInt(source -> source).toArray();
        return resultArray;
    }
}
// @lc code=end

