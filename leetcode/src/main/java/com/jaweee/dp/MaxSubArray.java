package com.jaweee.dp;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/17 14:50
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        // 这是有后效性的，-1， 2， -1， 3
        // f(i) 表示在i的时候最大和数组
        // f(i) = f(i-1) +
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
        }
        int ret = 0;
        for(int i = 0; i < n+1; i++){
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
}
