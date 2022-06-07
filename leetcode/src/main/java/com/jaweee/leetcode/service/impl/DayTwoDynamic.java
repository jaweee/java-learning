package com.jaweee.leetcode.service.impl;

import com.jaweee.leetcode.service.DayTwoService;

/**
 * @author: me
 * @title: DayTwoDynamic
 * @description: 动态规划的方法
 * @date: 2022/6/2 15:40
 */
public class DayTwoDynamic implements DayTwoService {
    @Override
    public int maxSubArray(int[] nums) {
        int pre =0, max=nums[0];
        for (int x : nums){
            pre = Math.max(pre+x, x);
            max = Math.max(pre, max);
        }
        return max;
    }
}
