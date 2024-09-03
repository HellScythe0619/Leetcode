/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    /**
     * 使用 while loop
     * @param matrix
     * @param target
     * @return
     */
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int low = 0;
    //     int high = matrix.length - 1;
    //     int row = 0;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         boolean hasNextArray = (mid + 1 < matrix.length);
    //         if (matrix[mid][0] <= target &&
    //                 (hasNextArray ? matrix[mid + 1][0] > target : true)) {
    //             row = mid;
    //             break;
    //         } else if (matrix[mid][0] < target) {
    //             low = mid + 1;
    //         } else if (matrix[mid][0] > target) {
    //             high = mid - 1;
    //         }
    //     }

    //     int start = 0;
    //     int end = matrix[row].length - 1;
    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if (matrix[row][mid] == target) {
    //             return true;
    //         } else if (matrix[row][mid] < target) {
    //             start = mid + 1;
    //         } else if (matrix[row][mid] > target) {
    //             end = mid - 1;
    //         }
    //     }
    //     return false;
    // }
    
    /**
     * 使用 遞迴 recursion
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchRow(matrix, target, 0, matrix.length - 1);
    }

    /**
     * 尋找 target 所在的列 row
     * @param matrix
     * @param target
     * @param low
     * @param high
     * @return
     */
    private boolean searchRow(int[][] matrix, int target, int low, int high) {
        int mid = low + (high - low) / 2;
        boolean hasNextArray = (mid + 1 < matrix.length);
        if (low > high) {
            return false;
        } else if (matrix[mid][0] <= target &&
                (hasNextArray ? matrix[mid + 1][0] > target : true)) {
            return searchTarget(matrix[mid], target, 0, matrix[mid].length - 1);
        } else if (matrix[mid][0] < target) {
            return searchRow(matrix, target, mid + 1, high);
        } else {
            return searchRow(matrix, target, low, mid - 1);
        }
    }

    /**
     * 尋找 target
     * @param row
     * @param target
     * @param low
     * @param high
     * @return
     */
    private boolean searchTarget(int[] row, int target, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low > high) {
            return false;
        } else if (row[mid] == target) {
            return true;
        } else if (row[mid] < target) {
            return searchTarget(row, target, mid + 1, high);
        } else {
            return searchTarget(row, target, low, mid - 1);
        }
    }
}
// @lc code=end

