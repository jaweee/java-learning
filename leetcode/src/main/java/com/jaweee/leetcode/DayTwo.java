package com.jaweee.leetcode;

import com.jaweee.leetcode.service.DayTwoService;

/**
 * @author: me
 * @title: DayTwo
 * @description:
 * @date: 2022/6/2 15:25
 */
public class DayTwo {

    // 委托DayTwoService 实现DayTwo的maxSubArray()
    public int maxSubArray(DayTwoService dayTwoService, int[] nums){
        return dayTwoService.maxSubArray(nums);
    }
}
