package com.jaweee.leetcode.service.impl;

import com.jaweee.leetcode.DayTwo;
import com.jaweee.leetcode.service.DayTwoService;

/**
 * @author: me
 * @title: DayTwoViolent
 * @description: 穷举了所有连续子数组的情况
 * @date: 2022/6/2 15:28
 */
public class DayTwoViolent implements DayTwoService {
    public int maxSubArray(int[] nums){
        int max = nums[0], n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
