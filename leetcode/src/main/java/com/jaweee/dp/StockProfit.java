package com.jaweee.dp;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/23 12:20
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class StockProfit {

    /**
     *  本题只有一次买入和卖出，求出最大利润
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        int miniprice = Integer.MAX_VALUE, n = prices.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        // dp[i+1] = max(dp[i], pirces[i] - miniprice)，这是动态规划的方程
        for (int i = 0; i < n; i++) {
            miniprice = Math.min(miniprice, prices[i]);
            dp[i+1] = Math.max(dp[i], prices[i] - miniprice);
        }
        return dp[n];
    }

    public int maxProfitII(int[] prices) {
        int miniprice = prices[0], n = prices.length, mp = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i-1] < prices[i]) {
                mp = mp + prices[i] - prices[i-1];
            }
        }
        return mp;
    }

}
