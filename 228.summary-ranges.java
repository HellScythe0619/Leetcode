/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            resultList.add(getResult(nums[0], nums[0]));
            return resultList;
        }

        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i - 1];
            int end = nums[i];
            if (temp + 1 != end) {
                resultList.add(getResult(start, temp));
                start = end;
            }

            if (i == nums.length - 1) {
                resultList.add(getResult(start, end));
            }
        }

        return resultList;
    }

    private String getResult(int start, int end) {
        StringBuilder sb = new StringBuilder();

        if (start != end) {
            sb.append(start);
            sb.append("->");
            sb.append(end);
        } else {
            sb.append(start);
        }

        return sb.toString();
    }
}
// @lc code=end

