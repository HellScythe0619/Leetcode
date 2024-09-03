/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {

    /**
     * Time Complexity: O(9 ^ M*N) -> O(9^81)
     * Space Complexity: O(1) (只使用既有的char array)
     * M: the number of row
     * N: the number of column
     * 每格數字都有9種可能性，共有81格子，最大化即O(9^81)
     * 
     * runtime: 73.93% (6 ms)
     * memory: 57.62% (40.9 MB)
     * 
     * 使用 遞迴+回溯 求解
     * 
     * @param board
     */
    public void solveSudoku(char[][] board) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    count++;
                }
            }
        }

        solve(board, count);
    }

    /**
     * 遞迴求解 + 回溯
     * @param board
     * @param count
     * @return
     */
    private boolean solve(char[][] board, int count) {
        // 如果所有空格都已填滿
        if (count == 9 * 9) {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // 檢查數字是否有效
                        if (isValid(board, i, j, num)) {
                            // 填入數字
                            board[i][j] = num;

                            // 遞迴求解剩餘部分
                            if (solve(board, count + 1)) {
                                return true;
                            }

                            board[i][j] = '.'; // 回溯
                        }
                    }

                    return false; // 如果無法填入valid num (遞迴碰壁)
                }
                
            }
        }

        return false;
    }

    /**
     * 檢核數字是否有重複，符合數獨規則
     * @param board
     * @param row
     * @param col
     * @param num
     * @return
     */
    private boolean isValid(char[][] board, int row, int col, char num) {
        // check col
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // check row
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // check 3x3 cube
        int cubeRow = (row / 3) * 3;
        int cubeCol = (col / 3) * 3;
        for (int i = cubeRow; i < cubeRow + 3; i++) {
            for (int j = cubeCol; j < cubeCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        // if num is non-repeat
        return true;
    }
}
// @lc code=end

