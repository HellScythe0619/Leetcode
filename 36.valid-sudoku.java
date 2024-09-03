/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * O(n^2)
     * runtime: 62.31%
     * memory: 76.75% (44.1 MB)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // System.out.println("row check start.");
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (row.contains(board[i][j])) {
                    return false;
                } else {
                    row.add(board[i][j]);
                }
            }
        }
        // System.out.println("row check end.");
        // System.out.println("col check start.");
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (col.contains(board[j][i])) {
                    return false;
                } else {
                    col.add(board[j][i]);
                }
            }
        }
        // System.out.println("col check end.");
        // System.out.println("box check start.");
        for (int a = 0; a < board.length; a += 3) {
            for (int b = 0; b < board[0].length; b += 3) {
                Set<Character> box = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i + a][j + b] == '.') {
                            continue;
                        }
                        if (box.contains(board[i + a][j + b])) {
                            return false;
                        } else {
                            box.add(board[i + a][j + b]);
                        }
                    }
                }
            }
        }
        // System.out.println("box check end.");
        return true;
    }
}
// @lc code=end

