/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    /**
     * Use DFS
     * Time Complexity: O(N * M)
     * Space Complexity: O(1)
     * ->   因為直接標記走過的原生 char[][] grid 為 '#'
     *      如果使用 int[][] visited 則為 O(N * M)
     * 
     * runtime: 50.82% (4 ms)
     * memory: 33.73% (49.7 MB)
     * 
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0' && grid[i][j] != '#') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return;
        }

        if (grid[i][j] == '#' || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '#';   // mark as '#'
        if (i > 0) {
            // up
            dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1) {
            // down
            dfs(grid, i + 1, j);
        }
        if (j > 0) {
            // left
            dfs(grid, i, j - 1);
        }
        if (j < grid[0].length - 1) {
            // right
            dfs(grid, i, j + 1);
        }
    }

}
// @lc code=end

