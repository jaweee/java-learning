package com.jaweee.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 23:20
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class DayOneTest {
    @Test
    public void testDayOneSolution(){
        DayOne dayOne = new DayOne();
        int num = dayOne.findKthLargest(new int[]{2,0,1,5,4}, 2);
        System.out.println("倒数第二个是："+num);
    }
}
