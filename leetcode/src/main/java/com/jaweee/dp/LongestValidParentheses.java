package com.jaweee.dp;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/3 14:17
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        // ret 是返回最长有效括号的长度，n是字符串的长度
        int ret = 0, n = s.length();
        // dp 是动态规划的保存以往数据的数组
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            // 如果是'('结尾就不用管了， 如果是')'将讨论两种情况
            if (s.charAt(i) == ')') {
                // 情况1，当前字符的前一个字符是'('
                if (s.charAt(i - 1) == '(') {
                    // 将dp[i] 根据dp[i-2]更新
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // 情况2，当前字符的前一个字符是')'，我们继续讨论在i-dp[i-1]-1的前一个字符是'('
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 判断
                    int increment = 0;
                    if (i - dp[i - 1] >= 2) {
                        increment = i - dp[i - 1];
                    }
                    else {
                        increment = 2;
                    }
                    dp[i] = dp[i - 1] + increment;
                }
                ret = Math.max(ret, dp[i]);
            }
        }
        return ret;
    }
}
