package com.jaweee.array;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/1/19 09:55
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ArrayTest {

    @Test
    public void testThreeSum() {
        int[] array = new int[]{ -1,0,1,2,-1,-4};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> list = t.threeSum(array);
        for (List temp : list) {
            System.out.println(temp);
        }
    }
}
