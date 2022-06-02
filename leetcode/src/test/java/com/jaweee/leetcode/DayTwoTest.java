package com.jaweee.leetcode;

import com.jaweee.leetcode.service.impl.DayTwoDynamic;
import com.jaweee.leetcode.service.impl.DayTwoViolent;
import org.junit.jupiter.api.Test;

/**
 * @author: me
 * @title: DayTwoTest
 * @description:
 * @date: 2022/6/2 16:27
 */
public class DayTwoTest {

    @Test
    public void testDayTwo(){
        // 用户定制化，用户决定使用那种策略，暴力解决的办法或者动态规划的办法
        DayTwo dayTwo = new DayTwo();
        int max = dayTwo.maxSubArray(new DayTwoViolent(), new int[]{1,2,-4, 5,2});
        System.out.println(max);

        System.out.println(dayTwo.maxSubArray(new DayTwoDynamic(), new int[]{1,2,-4,5,2}));
    }
}
