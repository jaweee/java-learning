package com.jaweee.algorithmtest;

import com.jaweee.algorithm.mydp.MyDpService;
import org.junit.Test;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/12/13 11:02
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class MyDpServiceTest {

    MyDpService myDpService = new MyDpService();

    @Test
    public void testMaxSubArray(){
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(myDpService.maxSubArray(array));
    }
}
