package com.jaweee.basicknowledge.dynamicprogramming.service.impl;

import com.jaweee.basicknowledge.dynamicprogramming.service.FibonacciSolution;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/6/3 06:53
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class FibonacciByNomalRecursion implements FibonacciSolution {

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
        return fib(n);
    }

    public int fib(int n){
        if (n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}
