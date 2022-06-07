package com.jaweee.basicknowledge.dynamicprogramming.service.impl;

import com.jaweee.basicknowledge.dynamicprogramming.service.FibonacciSolution;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/6/3 07:00
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class FibonacciByRecursionWithCaching implements FibonacciSolution {
    public int[] caching;
    /**
     * @param n
     * @return int
     * @description: TODO
     * @param: n
     * @author jiawei
     * @date 2022/6/3 06:55
     */
    @Override
    public int getFibonacci(int n) {
        caching = new int[n+1];
        return 0;
    }

}
