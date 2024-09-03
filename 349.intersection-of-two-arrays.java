/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * HashSet solution: 
     *  lambda: 4ms, runtime 30.28%, memory 45.12%(43.4MB)
     *  int Array: 2ms, runtime 95.63%, memory 33.21%(43.5MB)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numOneSet = new HashSet<>();
        for (int num : nums1) {
            numOneSet.add(num);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (numOneSet.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            resultArray[index++] = num;
        }

        return resultArray;
        // waste more runtime
        // return resultSet.stream().mapToInt(source -> source).toArray();
    }
    
    /**
     * only Array solution: 0ms, runtime 100%, memory 79.32%(42.4MB)
     * @param nums1
     * @param nums2
     * @return
     */
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     // 讓 nums1 為最短 Array
    //     if (nums1.length > nums2.length){
    //         return intersection(nums2, nums1);
    //     }

    //     int[] resultArray = new int[nums1.length];
    //     boolean[] existArray = new boolean[1001];
    //     for (int num : nums1) {
    //         existArray[num] = true;
    //     }

    //     int index = 0;
    //     for (int num : nums2) {
    //         if (existArray[num]) {
    //             resultArray[index++] = num;
    //             // 防止重複
    //             existArray[num] = false;
    //         }
    //     }

    //     // 移除最後一筆空0
    //     return Arrays.copyOfRange(resultArray, 0, index);
    // }

}
// @lc code=end

