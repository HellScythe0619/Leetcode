/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    /**
     * 2ms, runtime: 76.1%, memory: 88.89% (59.6MB)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyDay = Integer.MAX_VALUE; // 預設最大值，再找Array最小的
        int profit = 0; // 當日減去最小的販售日得到的收益
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyDay) {
                buyDay = prices[i];
            }
            profit = prices[i] - buyDay;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
		return maxProfit;
    }
}
// @lc code=end

