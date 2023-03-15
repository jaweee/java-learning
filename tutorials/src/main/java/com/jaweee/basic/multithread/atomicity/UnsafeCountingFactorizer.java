package com.jaweee.basic.multithread.atomicity;

import javax.servlet.Servlet;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/3/15 11:13
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class UnsafeCountingFactorizer {

    private long count = 0;

    public long getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public void decCount() {
        count--;
    }
}
